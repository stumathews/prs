
package DAL.DEL;

import javax.persistence.*;

/**
 * @author Stuart
 *
 */
@Entity
@Table(name = "Product")
public class Product {

    private Long id;
    private String title;
    private String whatIsIt;
    private String whoMadeIt;
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "what_is_it")
    public String getWhatIsIt() {
        return whatIsIt;
    }

    public void setWhatIsIt(String whatIsIt) {
        this.whatIsIt = whatIsIt;
    }

    @Column(name = "who_made_it")
    public String getWhoMadeIt() {
        return whoMadeIt;
    }

    public void setWhoMadeIt(String whoMadeIt) {
        this.whoMadeIt = whoMadeIt;
    }

    public Product() {
    }

    public Product(String title) {
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;

    }

    private void setId(Long id) {
        this.id = id;
    }

   
}
