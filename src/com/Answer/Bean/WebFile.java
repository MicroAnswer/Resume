package com.Answer.Bean;

import java.io.Serializable;
import java.net.URLEncoder;

public class WebFile  implements Serializable{
	private String FileName;
	private String FilePath;
	private String FilePicPath;
	private int Id;
	private int FileDownloadTimes;
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFilePath() {
		try{
		this.FilePath = URLEncoder.encode(FilePath, "UTF-8");}catch(Exception e){}
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public String getFilePicPath() {
		return FilePicPath;
	}
	public void setFilePicPath(String filePicPath) {
		FilePicPath = filePicPath;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getFileDownloadTimes() {
		return FileDownloadTimes;
	}
	public void setFileDownloadTimes(int fileDownloadTimes) {
		FileDownloadTimes = fileDownloadTimes;
	}
@Override
public String toString() {
	return Id+":"+FileName+"-"+FilePath+"-"+FileDownloadTimes+"-"+FilePicPath;
}
}
