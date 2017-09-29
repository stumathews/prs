package Website.Controllers;
 
import BOL.com.dotcypress.ljbeetle.upload.ImageShackHosting;
import BSL.IProductAdmin;
import BSL.LoginAdmin;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller that manages /products routes
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */ 
@Controller
@RequestMapping( value="/Product" )
public class ProductController 
{ 
	       
    private static final boolean DEBUG = false;
    private BSL.IProductAdmin productAdmin;    
    private BSL.LoginAdmin loginAdmin;

    @Autowired
    public void setLoginAdmin(LoginAdmin loginAdmin) {
        this.loginAdmin = loginAdmin;
    }
    @Autowired
    public void setProductAdmin(IProductAdmin productAdmin) {
        this.productAdmin = productAdmin;
    }
   
    /**
    * Gets all products in DB and adds bean to view which, show all the products.
    * @param model
    * @return view
    * @throws Exception 
    */
    @RequestMapping(value ="/ShowProductList",method = RequestMethod.GET)
    public String showProductsView(ModelMap model) throws Exception
    {            
        // Get all products in the database
        ArrayList< DAL.DEL.Product > products = productAdmin.getAllProducts( Common.GetGenAdminAuthToken() );
        // add products to model view
        model.addAttribute("products", products);
        return "Products/ShowProducts"; 
    }
    
    @RequestMapping(value="/Show/{productID}/json", method = RequestMethod.GET)
    @ResponseBody
    public DAL.DEL.Product getProductRaw( @PathVariable("productID") String productID, 
                               ModelMap model) throws Exception
    {
        return productAdmin.getProductByID(Common.GetGenAdminAuthToken(), productID);
    }
    
    

    /**
     * We store images on ImageShack, not locally. Lets not thrash imageshack's servers unless we're live. Use past summbited, cached dummy URL
     * @param product form command aka form backing object
     * @return url of pre cached image on imageshack's server
     */
    private String CacheImageURL(BOLO.Product product) 
    {        
        String url = "http://img825.imageshack.us/img825/4719/filedm.jpg";
        
        if (DEBUG) 
        {
            if( !product.getPicture().isEmpty())
            {
                url = ImageShackHosting.upload(product.getPicture().getBytes());
            }
        }
        
        return url;
    }

   
    /**
    * Show the add product view/form 
    * @param form the modelAttribute to populate the form
    * @param model model for the view
    * @return 
    */
    @RequestMapping( value="/ShowAdd", method = RequestMethod.GET)
    public String addProductView( BOLO.Product form, ModelMap model )
    {
        model.addAttribute("NewProduct", form);

        return "Products/AddProduct";
    }
    
    /**
    * Deletes a product 
    * @param productID the id of the product to delete
    * @param model view model
    * @return view to list all products after deletion
    * @throws Exception 
    */
    @RequestMapping( value="/Delete/{productID}", method = RequestMethod.GET)
    public String deleteProductByIDView( @PathVariable("productID") String productID, 
                                         ModelMap model) throws Exception
    {
        String token = Common.GetGenAdminAuthToken();
        productAdmin.deleteProductByID( token, productID );

        return "redirect:/Product/ShowProductList";
    }

    /**
    * Edit a product by given product id
    * @param productID id of product to edit
    * @param model views model
    * @return view to list all products
    * @throws Exception 
    */
    @RequestMapping( value="/ShowEdit/{productID}", method = RequestMethod.GET)
    public String editProductByIDView( @PathVariable("productID") String productID, ModelMap model) throws Exception
    {    
       BOLO.Product newProduct = MakeProductFormFromId(productID);
        
        return addProductView(newProduct, model);
    }
    
    @RequestMapping( value="/Show/{productID}", method = RequestMethod.GET)
    public String viewProduct( @PathVariable("productID") String productID, 
                               ModelMap model) throws Exception
    {    
        DAL.DEL.Product prod = productAdmin.getProductByID(Common.GetGenAdminAuthToken(), productID);        
        
        model.addAttribute("product",prod);
        return "Products/ViewProduct";
    }
    
    /**
    * Add product to db based on form values
    * @param product modelAttribute used to bind the form
    * @param model model for the view
    * @param result binding result
    * @return view of all products
    * @throws Exception 
    */       
    @RequestMapping(value ="/create", method = RequestMethod.POST)
    public String addProductToDB(@ModelAttribute("NewProduct") BOLO.Product product,
                                 ModelMap model, 
                                 BindingResult result) throws Exception
    {	

        if (checkUploadForErrors(result))
        return "redirect:/Product/ShowProductList";
        //FIXME: Should not be going directly to DEL from here. go via BSL
        DAL.DEL.Product prod = new DAL.DEL.Product();
        prod.setTitle(product.getTitle());
        prod.setWhatIsIt(product.getWhatIsIt());
        prod.setWhoMadeIt(product.getWhoMadeIt());
        String url = CacheImageURL(product);

        prod.setImageURL(url); 
        productAdmin.addProduct( Common.GetGenAdminAuthToken() , prod);	

        return "redirect:/Product/ShowProductList";

    }

    private BOLO.Product MakeProductFormFromId(String productID) throws Exception 
    {
        DAL.DEL.Product prod = productAdmin.getProductByID(Common.GetGenAdminAuthToken(), productID);
        /* Construct the form binding object aka command object: */
        BOLO.Product newProduct = new BOLO.Product();
        newProduct.setTitle(prod.getTitle());
        newProduct.setWhatIsIt(prod.getWhatIsIt());
        newProduct.setWhoMadeIt(prod.getWhoMadeIt());
        return newProduct;
    }
    
    
    
    /**
     * Check for errors with the upload 
     * @param result
     * @return 
     */
    private boolean checkUploadForErrors(BindingResult result) 
    {
        /* */
        if (result.hasErrors()) {
            for(ObjectError error : result.getAllErrors())
            {
            System.err.println("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
            }
            return true;
        }
        return false;
    }
    
}