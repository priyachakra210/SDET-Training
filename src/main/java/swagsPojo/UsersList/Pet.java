package swagsPojo.UsersList;

import swagsPojo.Category;

import java.util.List;
public class Pet {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrllist() {
        return photoUrllist;
    }

    public void setPhotoUrllist(List<String> photoUrllist) {
        this.photoUrllist = photoUrllist;
    }

    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Category category;
    private String name;
    private List<String> photoUrllist;
    private List<Tags> tagsList ;
    private String status;

}
