package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Blog;

interface BlogDaoInterface {
void insertBlog(Blog blog) throws  IOException, SQLException;
List<String> selectAllBlogs() throws SQLException;
}