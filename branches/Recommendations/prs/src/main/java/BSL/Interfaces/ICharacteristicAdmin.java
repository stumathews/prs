
package BSL.Interfaces;

import DEL.Characteristic;
import java.util.List;

/**
 * Contracts for implementations of Characteristics BSL objects
 * @author Stuart Mathews <stuart@stuartmathews.com>
 */
public interface ICharacteristicAdmin 
{
    public void addCharacteristic( String token, String name, String description ) throws Exception;

    public void addProductCharacteristic(String GetGenAuthToken,
                                         String productID,
                                         String title,
                                         String description,
                                         String review) throws Exception;

    public List<Characteristic> getProductCharacteristics(String GetGenAuthToken,
                                                          String productID) throws Exception;
    public List<BOLO.ProductCharacteristic> getAllCharacteristics(String token) throws Exception;
}
