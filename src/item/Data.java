package item;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

public class Data {

  
    /* List of picture(s) associated to this item */
    private ArrayList<String> pictures;

    /* Item id in Firebase database */
    private String mItemId;


    private final SimpleStringProperty mAuthor = new SimpleStringProperty("");

    private final SimpleStringProperty mName   = new SimpleStringProperty("");
    
    private final SimpleStringProperty mType   = new SimpleStringProperty(""); 
    
    private final SimpleStringProperty mPrice  = new SimpleStringProperty("");
    
    private final SimpleStringProperty mSize   = new SimpleStringProperty(""); 
    
    private final SimpleStringProperty mWeight = new SimpleStringProperty(""); 
    
    private boolean mAvailability = false;
    
    private boolean mSigned = false;
    
    private boolean mFramed = false;
    
    private boolean mUnique = false;
    
    

    public ArrayList<String> getPictures() {
        return pictures;
    }
    public Data() {
    }
    public Data(String name,
               String price,
               String author,
               String size,
               String weight,
               String type,
               String technique,
               boolean signed,
               boolean framed,
               boolean unique,
               boolean availability){
        
        mName.set(name);
        mAuthor.set(author);
        mType.set(type);
        mPrice.set(price);
        mSize.set(size);
        mWeight.set(weight);
        
        mSigned = signed;
        mFramed = framed;
        mUnique = unique;
        mAvailability=availability;
    }
    /*public Data(Cursor data){
            this.mItemId       = data.getString(0);
            this.mName         = data.getString(1);
            this.mPrice        = data.getString(2);
            this.mCurrency     = data.getString(3);
            this.mDescription  = getDescArray(data.getString(5));
            this.mSeller       = data.getString(6);
            this.mType         = data.getString(8);
            this.mAuthor       = data.getString(9);
            this.mSize         = data.getString(10);
            this.pictures      = getPicturesUrls(data.getString(11));
            this.mWeight       = data.getString(12);
            this.mAvailability = data.getString(14);
            this.mQuantity     = data.getString(15);
            this.mCommandState = data.getString(17);
            this.mCommandId    = data.getString(18);
            this.mFavouriteId  = data.getString(20);

            if(data.getString(19) != null)
                    this.mFavourite = true;
    }*/
    public String getItemId() {
        return mItemId;
    }


    public String getName() {
        return mName.get();
    }
    
    public void setName(String name) {
        mName.set(name);
    }
    
    public String getSize() {
        return mSize.get();
    }

    public String getAuthor() {
        return mAuthor.get();
    }

    /*public String geUrl() {
        return mUrl;
    }*/
    public String getWeight() {
        return mWeight.get();
    }

    public String getType() {
        return mType.get();
    }
    
    public void setType(String type) {
        mType.set(type);
    }

    /*public String getBrand() {
        return mBrand;
    }*/
    public String getPrice() {
        return mPrice.get();
    }
    
    public void setPrice(String price) {
        mPrice.set(price);
    }

    public boolean isAvailable() {
        return mAvailability;
    }
}
