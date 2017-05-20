package com.dingmouren.wallpager.model.bean;

import android.os.Parcelable;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class UnsplashResult implements Serializable{


    /**
     * id : xIFbDeGcy44
     * created_at : 2016-08-15T05:40:38-04:00
     * updated_at : 2017-05-18T23:26:36-04:00
     * width : 5760
     * height : 3840
     * color : #E5E1DE
     * likes : 191
     * liked_by_user : false
     * user : {"id":"4nD5SIrywGs","updated_at":"2017-05-19T02:07:23-04:00","username":"stefanjonhson","name":"Stefan Johnson","first_name":"Stefan","last_name":"Johnson","portfolio_url":"http://stefanjohnson.co.uk/","bio":"London based food, drink and editorial photographer. Shooting out of Clapham Studio in Battersea, London, I have worked with some of the UKs leading chefs, brands and magazines.","location":"London ","total_likes":0,"total_photos":5,"total_collections":0,"profile_image":{"small":"https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=1e06cd2892ca62b5d51b51f79d55e5bd","medium":"https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=38cc7f45342357ee168312a25a9cb8fd","large":"https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=cc874b863f22fcd377f9b5e5efe8a3d8"},"links":{"self":"https://api.unsplash.com/users/stefanjonhson","html":"http://unsplash.com/@stefanjonhson","photos":"https://api.unsplash.com/users/stefanjonhson/photos","likes":"https://api.unsplash.com/users/stefanjonhson/likes","portfolio":"https://api.unsplash.com/users/stefanjonhson/portfolio","following":"https://api.unsplash.com/users/stefanjonhson/following","followers":"https://api.unsplash.com/users/stefanjonhson/followers"}}
     * current_user_collections : []
     * urls : {"raw":"https://images.unsplash.com/photo-1471253794676-0f039a6aae9d","full":"https://images.unsplash.com/photo-1471253794676-0f039a6aae9d?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=fe50060f79c731863365a3c076aec395","regular":"https://images.unsplash.com/photo-1471253794676-0f039a6aae9d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=fc659a55688c3107eb638fc9f3136567","small":"https://images.unsplash.com/photo-1471253794676-0f039a6aae9d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=8607235745340a1826c3560df5328ccb","thumb":"https://images.unsplash.com/photo-1471253794676-0f039a6aae9d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=2c68e8e2387b616fade02085d48f26aa"}
     * categories : [{"id":3,"title":"Food & Drink","photo_count":3124,"links":{"self":"https://api.unsplash.com/categories/3","photos":"https://api.unsplash.com/categories/3/photos"}}]
     * links : {"self":"https://api.unsplash.com/photos/xIFbDeGcy44","html":"http://unsplash.com/photos/xIFbDeGcy44","download":"http://unsplash.com/photos/xIFbDeGcy44/download","download_location":"https://api.unsplash.com/photos/xIFbDeGcy44/download"}
     */

    private String id;
    private String created_at;
    private String updated_at;
    private int width;
    private int height;
    private String color;
    private int likes;
    private boolean liked_by_user;
    private User user;
    private Urls urls;
    private LinksX links;
//    private List<?> current_user_collections;
    private List<Categories> categories;

    public static UnsplashResult objectFromData(String str) {

        return new Gson().fromJson(str, UnsplashResult.class);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public LinksX getLinks() {
        return links;
    }

    public void setLinks(LinksX links) {
        this.links = links;
    }

//    public List<?> getCurrent_user_collections() {
//        return current_user_collections;
//    }
//
//    public void setCurrent_user_collections(List<?> current_user_collections) {
//        this.current_user_collections = current_user_collections;
//    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public static class User implements Serializable{
        /**
         * id : 4nD5SIrywGs
         * updated_at : 2017-05-19T02:07:23-04:00
         * username : stefanjonhson
         * name : Stefan Johnson
         * first_name : Stefan
         * last_name : Johnson
         * portfolio_url : http://stefanjohnson.co.uk/
         * bio : London based food, drink and editorial photographer. Shooting out of Clapham Studio in Battersea, London, I have worked with some of the UKs leading chefs, brands and magazines.
         * location : London
         * total_likes : 0
         * total_photos : 5
         * total_collections : 0
         * profile_image : {"small":"https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=1e06cd2892ca62b5d51b51f79d55e5bd","medium":"https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=38cc7f45342357ee168312a25a9cb8fd","large":"https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=cc874b863f22fcd377f9b5e5efe8a3d8"}
         * links : {"self":"https://api.unsplash.com/users/stefanjonhson","html":"http://unsplash.com/@stefanjonhson","photos":"https://api.unsplash.com/users/stefanjonhson/photos","likes":"https://api.unsplash.com/users/stefanjonhson/likes","portfolio":"https://api.unsplash.com/users/stefanjonhson/portfolio","following":"https://api.unsplash.com/users/stefanjonhson/following","followers":"https://api.unsplash.com/users/stefanjonhson/followers"}
         */

        private String id;
        private String updated_at;
        private String username;
        private String name;
        private String first_name;
        private String last_name;
        private String portfolio_url;
        private String bio;
        private String location;
        private int total_likes;
        private int total_photos;
        private int total_collections;
        private ProfileImage profile_image;
        private Links links;

        public static User objectFromData(String str) {

            return new Gson().fromJson(str, User.class);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getPortfolio_url() {
            return portfolio_url;
        }

        public void setPortfolio_url(String portfolio_url) {
            this.portfolio_url = portfolio_url;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getTotal_likes() {
            return total_likes;
        }

        public void setTotal_likes(int total_likes) {
            this.total_likes = total_likes;
        }

        public int getTotal_photos() {
            return total_photos;
        }

        public void setTotal_photos(int total_photos) {
            this.total_photos = total_photos;
        }

        public int getTotal_collections() {
            return total_collections;
        }

        public void setTotal_collections(int total_collections) {
            this.total_collections = total_collections;
        }

        public ProfileImage getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(ProfileImage profile_image) {
            this.profile_image = profile_image;
        }

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
        }

        public static class ProfileImage  implements Serializable{
            /**
             * small : https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=1e06cd2892ca62b5d51b51f79d55e5bd
             * medium : https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=38cc7f45342357ee168312a25a9cb8fd
             * large : https://images.unsplash.com/profile-fb-1471253165-7350e1314fde.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=cc874b863f22fcd377f9b5e5efe8a3d8
             */

            private String small;
            private String medium;
            private String large;

            public static ProfileImage objectFromData(String str) {

                return new Gson().fromJson(str, ProfileImage.class);
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }

        public static class Links implements Serializable{
            /**
             * self : https://api.unsplash.com/users/stefanjonhson
             * html : http://unsplash.com/@stefanjonhson
             * photos : https://api.unsplash.com/users/stefanjonhson/photos
             * likes : https://api.unsplash.com/users/stefanjonhson/likes
             * portfolio : https://api.unsplash.com/users/stefanjonhson/portfolio
             * following : https://api.unsplash.com/users/stefanjonhson/following
             * followers : https://api.unsplash.com/users/stefanjonhson/followers
             */

            private String self;
            private String html;
            private String photos;
            private String likes;
            private String portfolio;
            private String following;
            private String followers;

            public static Links objectFromData(String str) {

                return new Gson().fromJson(str, Links.class);
            }

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getPhotos() {
                return photos;
            }

            public void setPhotos(String photos) {
                this.photos = photos;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getPortfolio() {
                return portfolio;
            }

            public void setPortfolio(String portfolio) {
                this.portfolio = portfolio;
            }

            public String getFollowing() {
                return following;
            }

            public void setFollowing(String following) {
                this.following = following;
            }

            public String getFollowers() {
                return followers;
            }

            public void setFollowers(String followers) {
                this.followers = followers;
            }
        }
    }

    public static class Urls implements Serializable {
        /**
         * raw : https://images.unsplash.com/photo-1471253794676-0f039a6aae9d
         * full : https://images.unsplash.com/photo-1471253794676-0f039a6aae9d?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=fe50060f79c731863365a3c076aec395
         * regular : https://images.unsplash.com/photo-1471253794676-0f039a6aae9d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=fc659a55688c3107eb638fc9f3136567
         * small : https://images.unsplash.com/photo-1471253794676-0f039a6aae9d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=8607235745340a1826c3560df5328ccb
         * thumb : https://images.unsplash.com/photo-1471253794676-0f039a6aae9d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=2c68e8e2387b616fade02085d48f26aa
         */

        private String raw;
        private String full;
        private String regular;
        private String small;
        private String thumb;

        public static Urls objectFromData(String str) {

            return new Gson().fromJson(str, Urls.class);
        }

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }

    public static class LinksX implements Serializable {
        /**
         * self : https://api.unsplash.com/photos/xIFbDeGcy44
         * html : http://unsplash.com/photos/xIFbDeGcy44
         * download : http://unsplash.com/photos/xIFbDeGcy44/download
         * download_location : https://api.unsplash.com/photos/xIFbDeGcy44/download
         */

        private String self;
        private String html;
        private String download;
        private String download_location;

        public static LinksX objectFromData(String str) {

            return new Gson().fromJson(str, LinksX.class);
        }

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getDownload_location() {
            return download_location;
        }

        public void setDownload_location(String download_location) {
            this.download_location = download_location;
        }
    }

    public static class Categories implements Serializable{
        /**
         * id : 3
         * title : Food & Drink
         * photo_count : 3124
         * links : {"self":"https://api.unsplash.com/categories/3","photos":"https://api.unsplash.com/categories/3/photos"}
         */

        private int id;
        private String title;
        private int photo_count;
        private LinksXX links;

        public static Categories objectFromData(String str) {

            return new Gson().fromJson(str, Categories.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPhoto_count() {
            return photo_count;
        }

        public void setPhoto_count(int photo_count) {
            this.photo_count = photo_count;
        }

        public LinksXX getLinks() {
            return links;
        }

        public void setLinks(LinksXX links) {
            this.links = links;
        }

        public static class LinksXX implements Serializable{
            /**
             * self : https://api.unsplash.com/categories/3
             * photos : https://api.unsplash.com/categories/3/photos
             */

            private String self;
            private String photos;

            public static LinksXX objectFromData(String str) {

                return new Gson().fromJson(str, LinksXX.class);
            }

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getPhotos() {
                return photos;
            }

            public void setPhotos(String photos) {
                this.photos = photos;
            }
        }
    }
}
