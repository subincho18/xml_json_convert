package kr.nextree.edu.hib;

public class User {
	private String title;
	private String content;
	private String writer;
	
	public User() {}
	
	public User(String title, String content, String writer) {
		this.setTitle(title);
		this.setContent(content);
		this.setWriter(writer);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}


}
