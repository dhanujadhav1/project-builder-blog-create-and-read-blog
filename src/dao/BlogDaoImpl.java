package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	//method to insert the blog into the database.
	@Override
	public void insertBlog(Blog blog) throws  IOException, SQLException {
		ConnectionManager cm = new ConnectionManager();
		Connection con = null;
		try {
			con = cm.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "insert into blog (blogId,blogTitle, blogDescription, postedOn) values(?,?,?,?)";
		
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, blog.getBlogId());
		ps.setString(2, blog.getBlogTitle());
		ps.setString(3, blog.getBlogDescription());
		ps.setDate(4,blog.getPostedOn() );
		ps.executeUpdate();
		// TODO Auto-generated method stub
		
	}
	
	//method to retrieve the blogs from the database.
@Override
	public List<String> selectAllBlogs() throws SQLException {
	ConnectionManager cm = new ConnectionManager();
	Connection con = null;
	List<String> list= new ArrayList<>();
	String sql = "select blogTitle from blog";
	PreparedStatement ps= con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		list.add(rs.getString(2));
		
	}
	
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}