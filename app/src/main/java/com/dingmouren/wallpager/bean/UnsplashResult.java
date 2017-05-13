package com.dingmouren.wallpager.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dingmouren on 2017/5/2.
 */

public class UnsplashResult {

    /**
     * id : Lm5rkxzgiFQ
     * created_at : 2017-04-30T18:15:19-04:00
     * updated_at : 2017-05-01T21:26:19-04:00
     * width : 3984
     * height : 5976
     * color : #0C0A08
     * likes : 145
     * liked_by_user : false
     * user : {"id":"Q9Ig7Srx2OI","updated_at":"2017-05-01T21:27:53-04:00","username":"reddangelo16","name":"Redd Angelo","first_name":"Redd","last_name":"Angelo","portfolio_url":"https://www.instagram.com/reddangelo/","bio":"Edmonton Based Photographer. 21 . Graphic and Web Designer by trade.","location":"Edmonton, Alberta","total_likes":132,"total_photos":222,"total_collections":0,"profile_image":{"small":"https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=58fbaab52f4533ddb08523e709fe4ff0","medium":"https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=91cb79af71fba3b28b4098eab7e44b1f","large":"https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ea44860ec6c87a601ea2c048b3721e8f"},"links":{"self":"https://api.unsplash.com/users/reddangelo16","html":"http://unsplash.com/@reddangelo16","photos":"https://api.unsplash.com/users/reddangelo16/photos","likes":"https://api.unsplash.com/users/reddangelo16/likes","portfolio":"https://api.unsplash.com/users/reddangelo16/portfolio","following":"https://api.unsplash.com/users/reddangelo16/following","followers":"https://api.unsplash.com/users/reddangelo16/followers"}}
     * current_user_collections : []
     * urls : {"raw":"https://images.unsplash.com/photo-1493589976221-c2357c31ad77","full":"https://images.unsplash.com/photo-1493589976221-c2357c31ad77?ixlib=rb-0.3.5&q=100&fm=jpg&crop=entropy&cs=tinysrgb&s=0575ba7f39eda11006574833ffab3ffa","regular":"https://images.unsplash.com/photo-1493589976221-c2357c31ad77?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=d60792004dbbb366e08c4187d068a9b2","small":"https://images.unsplash.com/photo-1493589976221-c2357c31ad77?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=994acc8d9fc11878ebd80a3642d15a83","thumb":"https://images.unsplash.com/photo-1493589976221-c2357c31ad77?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=f3a323d94512e483b895f53ec418b8eb"}
     * categories : []
     * links : {"self":"https://api.unsplash.com/photos/Lm5rkxzgiFQ","html":"http://unsplash.com/photos/Lm5rkxzgiFQ","download":"http://unsplash.com/photos/Lm5rkxzgiFQ/download","download_location":"https://api.unsplash.com/photos/Lm5rkxzgiFQ/download"}
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
    private List<?> current_user_collections;
    private List<?> categories;

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

    public List<?> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<?> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public List<?> getCategories() {
        return categories;
    }

    public void setCategories(List<?> categories) {
        this.categories = categories;
    }

    public static class User {
        /**
         * id : Q9Ig7Srx2OI
         * updated_at : 2017-05-01T21:27:53-04:00
         * username : reddangelo16
         * name : Redd Angelo
         * first_name : Redd
         * last_name : Angelo
         * portfolio_url : https://www.instagram.com/reddangelo/
         * bio : Edmonton Based Photographer. 21 . Graphic and Web Designer by trade.
         * location : Edmonton, Alberta
         * total_likes : 132
         * total_photos : 222
         * total_collections : 0
         * profile_image : {"small":"https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=58fbaab52f4533ddb08523e709fe4ff0","medium":"https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=91cb79af71fba3b28b4098eab7e44b1f","large":"https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ea44860ec6c87a601ea2c048b3721e8f"}
         * links : {"self":"https://api.unsplash.com/users/reddangelo16","html":"http://unsplash.com/@reddangelo16","photos":"https://api.unsplash.com/users/reddangelo16/photos","likes":"https://api.unsplash.com/users/reddangelo16/likes","portfolio":"https://api.unsplash.com/users/reddangelo16/portfolio","following":"https://api.unsplash.com/users/reddangelo16/following","followers":"https://api.unsplash.com/users/reddangelo16/followers"}
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

        public static class ProfileImage {
            /**
             * small : https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=58fbaab52f4533ddb08523e709fe4ff0
             * medium : https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=91cb79af71fba3b28b4098eab7e44b1f
             * large : https://images.unsplash.com/profile-1484189708643-d31cffb5e906?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ea44860ec6c87a601ea2c048b3721e8f
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

        public static class Links {
            /**
             * self : https://api.unsplash.com/users/reddangelo16
             * html : http://unsplash.com/@reddangelo16
             * photos : https://api.unsplash.com/users/reddangelo16/photos
             * likes : https://api.unsplash.com/users/reddangelo16/likes
             * portfolio : https://api.unsplash.com/users/reddangelo16/portfolio
             * following : https://api.unsplash.com/users/reddangelo16/following
             * followers : https://api.unsplash.com/users/reddangelo16/followers
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

    public static class Urls {
        /**
         * raw : https://images.unsplash.com/photo-1493589976221-c2357c31ad77
         * full : https://images.unsplash.com/photo-1493589976221-c2357c31ad77?ixlib=rb-0.3.5&q=100&fm=jpg&crop=entropy&cs=tinysrgb&s=0575ba7f39eda11006574833ffab3ffa
         * regular : https://images.unsplash.com/photo-1493589976221-c2357c31ad77?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=d60792004dbbb366e08c4187d068a9b2
         * small : https://images.unsplash.com/photo-1493589976221-c2357c31ad77?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=994acc8d9fc11878ebd80a3642d15a83
         * thumb : https://images.unsplash.com/photo-1493589976221-c2357c31ad77?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=f3a323d94512e483b895f53ec418b8eb
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

    public static class LinksX {
        /**
         * self : https://api.unsplash.com/photos/Lm5rkxzgiFQ
         * html : http://unsplash.com/photos/Lm5rkxzgiFQ
         * download : http://unsplash.com/photos/Lm5rkxzgiFQ/download
         * download_location : https://api.unsplash.com/photos/Lm5rkxzgiFQ/download
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
}
