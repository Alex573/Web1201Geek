package com.muy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testforgeek?characterEncoding=UTF-8","root","root");
        return conn;
    }


    static  List<Post> posts;
    static{
        posts = new ArrayList<>();
        posts.add(new Post(1,"hellouy1"));
        posts.add(new Post(2,"hellouy2"));
        posts.add(new Post(3,"hellouy3"));
        posts.add(new Post(4,"hellouy4"));
        posts.add(new Post(5,"hellouy5"));
    }

    public static List<Post> getPost() throws SQLException, ClassNotFoundException {
        try(Connection c = getConnection();
            Statement stmt = c.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT id,txt FROM posts")) {
            ArrayList<Post> posts = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String txt = rs.getString(2);
                posts.add(new Post(id, txt));
                // System.out.println("Total number of books in the table : " + id);
            }


            return posts;
        }
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

//        Post d = null;
//       // posts.stream().filter(post -> post.id==id).forEach(d = posts);
//        for (Post p : posts) {
//            if (p.id == id) {
//                d=p;
//            }
//        }
//        if (d != null){
//            posts.remove(d);
//        }

        try(Connection c = getConnection();
           PreparedStatement ps = c.prepareStatement("DELETE FROM  posts WHERE id=?")) {
            ps.setInt(1,id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addpost(String txt) {
//        posts.add(new Post((posts.size()+1),txt));
        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO posts (txt) VALUES(?)")) {
            ps.setString(1,txt);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getPost());
    }
}
