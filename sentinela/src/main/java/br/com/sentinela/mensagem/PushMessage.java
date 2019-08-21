package br.com.sentinela.mensagem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class PushMessage {

	
	public class Data{
		@JsonInclude(Include.NON_NULL)
		private String title;
		
		@JsonInclude(Include.NON_NULL)
		private String body;
		
		@JsonInclude(Include.NON_NULL)
		private String vibrate;
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getVibrate() {
			return "[100, 50, 100]";
		}

		public void setVibrate(String vibrate) {
			this.vibrate = vibrate;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		@Override
		public String toString() {
			return "Data [title=" + title + ", body=" + body + ", vibrate=" + vibrate + "]";
		}
		

	}
	
	public class Data2{
		
		@JsonInclude(Include.NON_NULL)
		private boolean foreground = true;
		@JsonInclude(Include.NON_NULL)
		private String title = "RocketMax";
		@JsonInclude(Include.NON_NULL)
		private String body = "";
		@JsonInclude(Include.NON_NULL)
		private String page = "my";
		@JsonInclude(Include.NON_NULL)
		private Long id;
		
		
		public boolean isForeground() {
			return foreground;
		}
		public void setForeground(boolean foreground) {
			this.foreground = foreground;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		
		public String getPage() {
			return page;
		}
		public void setPage(String page) {
			this.page = page;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "Data2 [foreground=" + foreground + ", title=" + title + ", body=" + body + ", page=" + page
					+ ", id=" + id + "]";
		}
	}
	
	@JsonInclude(Include.NON_NULL)
	Data notification;
	
	@JsonInclude(Include.NON_NULL)
	Data2 data;
	
	@JsonIgnore
	String platform;
	
	public PushMessage() {
		notification = new Data();
		data = new Data2();
	}
	
	@JsonInclude
	public Data getNotification() {
		return notification;
	}
	
	@JsonInclude
	public Data2 getData() {
		return data;
	}
	
	@JsonInclude(Include.NON_NULL)
	private String to;
	
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String deviceToken) {
		this.to = deviceToken;
	}

	@JsonIgnore
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "PushMessage [notification=" + notification + ", platform=" + platform + ", to=" + to + "]";
	}
	
}
