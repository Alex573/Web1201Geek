package com.muy;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    static  List<Post> posts;
    static{
        posts = new ArrayList<>();
        posts.add(new Post(1,"hellouy1"));
        posts.add(new Post(2,"hellouy2"));
        posts.add(new Post(3,"hellouy3"));
        posts.add(new Post(4,"hellouy4"));
        posts.add(new Post(5,"hellouy5"));
    }

    public static List<Post> getPost(){
        return posts;
    }

    public static void deletePost(int id){
        //7
//        for (Post post1 : posts) {
//            if (post1.id == id) {
//                posts.remove(post1);
//            }
//        }
//        //8
//        posts.stream().filter(post -> post.id == id).forEach(posts::remove);
        //8 small

       // posts.removeIf(post -> post.id == id);

        Post d = null;
       // posts.stream().filter(post -> post.id==id).forEach(d = posts);
        for (Post p : posts) {
            if (p.id == id) {
                d=p;
            }
        }
        if (d != null){
            posts.remove(d);
        }
    }

    public static void addpost(String txt) {
        posts.add(new Post((posts.size()+1),txt));
    }
}
