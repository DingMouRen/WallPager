package com.dingmouren.wallpager.model.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dingmouren on 2017/5/20.
 */

public class PhotoInfo {

    /**
     * id : oCbrjDECdK0
     * created_at : 2016-08-14T07:40:54-04:00
     * updated_at : 2016-08-14T23:30:37-04:00
     * width : 3824
     * height : 3064
     * color : #EEE2DB
     * slug : null
     * downloads : 118
     * likes : 37
     * views : 150861
     * liked_by_user : false
     * exif : {"make":"Panasonic","model":"DMC-GM1","exposure_time":"1/4000","aperture":null,"focal_length":"20","iso":200}
     * current_user_collections : []
     * urls : {"raw":"https://images.unsplash.com/photo-1471174826377-f3da3bd635e4","full":"https://images.unsplash.com/photo-1471174826377-f3da3bd635e4?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=2b803f28ca67b2563ebbb4119a6bd5b0","regular":"https://images.unsplash.com/photo-1471174826377-f3da3bd635e4?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=d13aff73ebd7381986f63661be62347b","small":"https://images.unsplash.com/photo-1471174826377-f3da3bd635e4?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=b7902c825644e56bfa4f66eed067fe4e","thumb":"https://images.unsplash.com/photo-1471174826377-f3da3bd635e4?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=d6c02ab86260199bb4e22797c896889e"}
     * categories : [{"id":8,"title":"Objects","photo_count":13840,"links":{"self":"https://api.unsplash.com/categories/8","photos":"https://api.unsplash.com/categories/8/photos"}},{"id":8,"title":"Objects","photo_count":13840,"links":{"self":"https://api.unsplash.com/categories/8","photos":"https://api.unsplash.com/categories/8/photos"}},{"id":7,"title":"Technology","photo_count":1407,"links":{"self":"https://api.unsplash.com/categories/7","photos":"https://api.unsplash.com/categories/7/photos"}}]
     * links : {"self":"https://api.unsplash.com/photos/oCbrjDECdK0","html":"http://unsplash.com/photos/oCbrjDECdK0","download":"http://unsplash.com/photos/oCbrjDECdK0/download","download_location":"https://api.unsplash.com/photos/oCbrjDECdK0/download"}
     * user : {"id":"wpPybVWRH5A","updated_at":"2017-05-19T19:56:17-04:00","username":"ultralinx","name":"Oliur Rahman","first_name":"Oliur","last_name":"Rahman","portfolio_url":"http://oliur.com","bio":"I'm a designer and entrepreneur who enjoys taking pictures in my free time.","location":"United Kingdom","total_likes":0,"total_photos":12,"total_collections":0,"profile_image":{"small":"https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=7c661ead6e674f4b453fb13ad5968b31","medium":"https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=c995b27989309541e4ebc53452a9086c","large":"https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=0955f4e2ab31fe98fa04e8eab788d232"},"links":{"self":"https://api.unsplash.com/users/ultralinx","html":"http://unsplash.com/@ultralinx","photos":"https://api.unsplash.com/users/ultralinx/photos","likes":"https://api.unsplash.com/users/ultralinx/likes","portfolio":"https://api.unsplash.com/users/ultralinx/portfolio","following":"https://api.unsplash.com/users/ultralinx/following","followers":"https://api.unsplash.com/users/ultralinx/followers"}}
     */

    private String id;
    private String created_at;
    private String updated_at;
    private int width;
    private int height;
    private String color;
    private Object slug;
    private int downloads;
    private int likes;
    private int views;
    private boolean liked_by_user;
    private Exif exif;
    private Urls urls;
    private Links links;
    private User user;
    private List<?> current_user_collections;
    private List<Categories> categories;

    public static PhotoInfo objectFromData(String str) {

        return new Gson().fromJson(str, PhotoInfo.class);
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

    public Object getSlug() {
        return slug;
    }

    public void setSlug(Object slug) {
        this.slug = slug;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public Exif getExif() {
        return exif;
    }

    public void setExif(Exif exif) {
        this.exif = exif;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<?> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<?> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public static class Exif {
        /**
         * make : Panasonic
         * model : DMC-GM1
         * exposure_time : 1/4000
         * aperture : null
         * focal_length : 20
         * iso : 200
         */

        private String make;
        private String model;
        private String exposure_time;
        private Object aperture;
        private String focal_length;
        private int iso;

        public static Exif objectFromData(String str) {

            return new Gson().fromJson(str, Exif.class);
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getExposure_time() {
            return exposure_time;
        }

        public void setExposure_time(String exposure_time) {
            this.exposure_time = exposure_time;
        }

        public Object getAperture() {
            return aperture;
        }

        public void setAperture(Object aperture) {
            this.aperture = aperture;
        }

        public String getFocal_length() {
            return focal_length;
        }

        public void setFocal_length(String focal_length) {
            this.focal_length = focal_length;
        }

        public int getIso() {
            return iso;
        }

        public void setIso(int iso) {
            this.iso = iso;
        }
    }

    public static class Urls {
        /**
         * raw : https://images.unsplash.com/photo-1471174826377-f3da3bd635e4
         * full : https://images.unsplash.com/photo-1471174826377-f3da3bd635e4?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=2b803f28ca67b2563ebbb4119a6bd5b0
         * regular : https://images.unsplash.com/photo-1471174826377-f3da3bd635e4?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=d13aff73ebd7381986f63661be62347b
         * small : https://images.unsplash.com/photo-1471174826377-f3da3bd635e4?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=b7902c825644e56bfa4f66eed067fe4e
         * thumb : https://images.unsplash.com/photo-1471174826377-f3da3bd635e4?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=d6c02ab86260199bb4e22797c896889e
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

    public static class Links {
        /**
         * self : https://api.unsplash.com/photos/oCbrjDECdK0
         * html : http://unsplash.com/photos/oCbrjDECdK0
         * download : http://unsplash.com/photos/oCbrjDECdK0/download
         * download_location : https://api.unsplash.com/photos/oCbrjDECdK0/download
         */

        private String self;
        private String html;
        private String download;
        private String download_location;

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

    public static class User {
        /**
         * id : wpPybVWRH5A
         * updated_at : 2017-05-19T19:56:17-04:00
         * username : ultralinx
         * name : Oliur Rahman
         * first_name : Oliur
         * last_name : Rahman
         * portfolio_url : http://oliur.com
         * bio : I'm a designer and entrepreneur who enjoys taking pictures in my free time.
         * location : United Kingdom
         * total_likes : 0
         * total_photos : 12
         * total_collections : 0
         * profile_image : {"small":"https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=7c661ead6e674f4b453fb13ad5968b31","medium":"https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=c995b27989309541e4ebc53452a9086c","large":"https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=0955f4e2ab31fe98fa04e8eab788d232"}
         * links : {"self":"https://api.unsplash.com/users/ultralinx","html":"http://unsplash.com/@ultralinx","photos":"https://api.unsplash.com/users/ultralinx/photos","likes":"https://api.unsplash.com/users/ultralinx/likes","portfolio":"https://api.unsplash.com/users/ultralinx/portfolio","following":"https://api.unsplash.com/users/ultralinx/following","followers":"https://api.unsplash.com/users/ultralinx/followers"}
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
        private LinksX links;

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

        public LinksX getLinks() {
            return links;
        }

        public void setLinks(LinksX links) {
            this.links = links;
        }

        public static class ProfileImage {
            /**
             * small : https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=7c661ead6e674f4b453fb13ad5968b31
             * medium : https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=c995b27989309541e4ebc53452a9086c
             * large : https://images.unsplash.com/profile-1469963995475-273f3742cda7?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=0955f4e2ab31fe98fa04e8eab788d232
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

        public static class LinksX {
            /**
             * self : https://api.unsplash.com/users/ultralinx
             * html : http://unsplash.com/@ultralinx
             * photos : https://api.unsplash.com/users/ultralinx/photos
             * likes : https://api.unsplash.com/users/ultralinx/likes
             * portfolio : https://api.unsplash.com/users/ultralinx/portfolio
             * following : https://api.unsplash.com/users/ultralinx/following
             * followers : https://api.unsplash.com/users/ultralinx/followers
             */

            private String self;
            private String html;
            private String photos;
            private String likes;
            private String portfolio;
            private String following;
            private String followers;

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

    public static class Categories {
        /**
         * id : 8
         * title : Objects
         * photo_count : 13840
         * links : {"self":"https://api.unsplash.com/categories/8","photos":"https://api.unsplash.com/categories/8/photos"}
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

        public static class LinksXX {
            /**
             * self : https://api.unsplash.com/categories/8
             * photos : https://api.unsplash.com/categories/8/photos
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
