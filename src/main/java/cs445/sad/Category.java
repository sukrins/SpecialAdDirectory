package cs445.sad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonPropertyOrder({"categoryID"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {

    private String categoryID;
    private String categoryName;

    public Category() {
    }

    public Category(String categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryID(String categoryId) {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public String key(String categoryId) throws CategoryNotFoundException, AdvertiserNotFoundException, ListingNotFoundException {
        CategoryDao dao = new CategoryDao();
        for (Category category : dao.categories.values()) {
            category.getCategoryID(categoryId);
        }
        return categoryId;
    }

}
