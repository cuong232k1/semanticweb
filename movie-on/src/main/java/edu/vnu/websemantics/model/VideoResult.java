package edu.vnu.websemantics.model;

public class VideoResult {
	private String videoId;
	private String title;
//	private String rate;
//
//	public void setRate(String rate) {
//		this.rate = rate;
//	}
//
//	public String getRate() {
//		return rate;
//	}

	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "VideoResult [videoId=" + videoId + ", title=" + title + "]";
	}

}
