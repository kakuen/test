package jp.co.fitec.lesson.kaku.bookstore.DAO;

	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;



	import jp.co.fitec.lesson.kaku.bookstore.ConnectionUtils;
	import jp.co.fitec.lesson.kaku.bookstore.DAOException;
	import jp.co.fitec.lesson.kaku.bookstore.entity.Book;

	public class BookDAO {
		enum UpdateType{
			insert,update,delete
		}
		
		public List<Book> findAll()throws DAOException{
			return findany(null);
		}

		public Book findByIsbn(String index)throws DAOException{
			return findany(index).get(0);
		}

		public int insert(Book book)throws DAOException{
			return doany(book,UpdateType.insert);
		}

		public int update(Book book)throws DAOException{
			return doany(book,UpdateType.update);
		}
		
		public int delete(Book book)throws DAOException{
			return doany(book,UpdateType.delete);
		}
		
//		★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//		内部メソッド
//		★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		
		private List<Book> findany(String index)throws DAOException{
			List<Book> bookList = new ArrayList<>();
			String sql = "select * from book";
			if(index != null){
				sql = sql + " where isbn =" + index;
			}
			
			try(Connection conn = ConnectionUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){

				while(rs.next()){
					bookList.add(new Book(rs.getString("isbn"),rs.getString("title"),
							rs.getDouble("price"),rs.getString("publisherCode"),rs.getDate("releaseDate")));
				}
				return bookList;
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		private int doany(Book book,UpdateType updateType)throws DAOException {
//			String isbn = book.getIsbn();
//			String title = book.getTitle();
//			Double price = book.getPrice();
//			String pubisherCode = book.getPublisherCode();
//			Date releaseDate = book.getReleaseDate();
			
			int count = 0;
			String sql = null;
			Object[] params = null;
			
			switch(updateType){
			case insert:
				sql = "insert into book values(?,?,?,?,?)";
				params = new Object[]{book.getIsbn(),book.getTitle(),book.getPrice(),book.getPublisherCode(),book.getReleaseDate()};
				break;
			case update:
				sql = "update book set title = ?, price = ?, publisherCode = ?,releaseDate = ? where isbn = ?";
				params = new Object[]{book.getTitle(),book.getPrice(),book.getPublisherCode(),book.getReleaseDate(),book.getIsbn()};
				break;
			case delete:
				sql = "delete from book where isbn = ?";
				params = new Object[]{book.getTitle()};
				break;
			}
			
			
			try(Connection conn = ConnectionUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql)){
				for(int i = 0; i < params.length; i++){
					pstmt.setObject(i+1, params[i]);
				}
				count = pstmt.executeUpdate();
				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return count;
		}


}
