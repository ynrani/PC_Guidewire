package com.tesda.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
	private List<String> fileList;
	private String srcFolder;
	private String outZip;
	
    public ZipUtil(String srcFolder,String outZip){
	setFileList(new ArrayList<String>());
	this.setSrcFolder(srcFolder);
	this.setOutZip(outZip);
    }
	
   /* public static void main( String[] args )
    {
    	ZipUtil appZip = new ZipUtil("C:\\Users\\shalaka.adelkar\\Downloads\\TEST2975371.xls","C:\\Users\\shalaka.adelkar\\Downloads\\MyFile.zip");
    	appZip.generateZipFile(appZip);
    }*/
    
    public void generateZipFile(ZipUtil appZip){
    	appZip.generateFileList(new File(appZip.getSrcFolder()),appZip.getSrcFolder());
    	appZip.zipIt(appZip.getOutZip(),appZip.getSrcFolder());
    }
    
    /**
     * Zip it
     * @param zipFile output ZIP file location
     */
    public void zipIt(String zipFile,String strFolder){

     byte[] buffer = new byte[2048];
    	
     try{
    		
    	FileOutputStream fos = new FileOutputStream(zipFile);
    	ZipOutputStream zos = new ZipOutputStream(fos);
    		
    	System.out.println("Output to Zip : " + zipFile);
    		
    	for(String file : this.getFileList()){
    			
    		System.out.println("File Added : " + file);
    		ZipEntry ze= new ZipEntry(file);
        	zos.putNextEntry(ze);
               
        	FileInputStream in = 
                       new FileInputStream(strFolder + File.separator + file);
       	   
        	int len;
        	while ((len = in.read(buffer)) > 0) {
        		zos.write(buffer, 0, len);
        	}
               
        	in.close();
    	}
    		
    	zos.closeEntry();
    	//remember close it
    	zos.close();
          
    	System.out.println("Done");
    }catch(IOException ex){
       ex.printStackTrace();   
    }
   }
    
    /**
     * Traverse a directory and get all files,
     * and add the file into fileList  
     * @param node file or directory
     */
    public void generateFileList(File node,String srcFolder){

    	//add file only
	if(node.isFile()){
		getFileList().add(generateZipEntry(node.getAbsoluteFile().toString(),srcFolder));
	}
		
	if(node.isDirectory()){
		String[] subNote = node.list();
		if(subNote != null && subNote.length > 0){
		for(String filename : subNote){
			generateFileList(new File(node, filename),srcFolder);
		}
		}
	}
 
    }

    /**
     * Format the file path for zip
     * @param file file path
     * @return Formatted file path
     */
    private String generateZipEntry(String file,String srcFolder){
    	return file.substring(srcFolder.length()+1, file.length());
    }

	public String getSrcFolder() {
		return srcFolder;
	}

	public void setSrcFolder(String srcFolder) {
		this.srcFolder = srcFolder;
	}

	public String getOutZip() {
		return outZip;
	}

	public void setOutZip(String outZip) {
		this.outZip = outZip;
	}

	public List<String> getFileList() {
		return fileList;
	}

	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}
}
