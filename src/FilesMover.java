import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesMover {

	public static void main(String[] args) throws IOException {

		int success = 0, fail = 0;
		File dir = new File(Constants.SRC_DIR);
		File[] files = dir.listFiles();
		
		//create Output directories i.e according to templete
		new File(Constants.OUT_DIR+"\\2013\\"+Constants.STATE+"\\"+Constants.DISTRICT).mkdirs();
		new File(Constants.OUT_DIR+"\\2014\\"+Constants.STATE+"\\"+Constants.DISTRICT).mkdirs();
		new File(Constants.OUT_DIR+"\\2015\\"+Constants.STATE+"\\"+Constants.DISTRICT).mkdirs();
		new File(Constants.OUT_DIR+"\\2016\\"+Constants.STATE+"\\"+Constants.DISTRICT).mkdirs();
		
		for (File file : files) {

			String filePath = file.getPath();
			String fileName = file.getName();

			if (filePath.contains("hmis")) {
				
				//get the year i.e 13,14,15,16
				String[] temp = filePath.split("-");
				String year = temp[2];

				//output directory show be present
				//move(src,dest)
				Path n = Files.move(Paths.get(Constants.SRC_DIR + "\\" + fileName),
						Paths.get(Constants.OUT_DIR + "\\20" + year+"\\"+Constants.STATE+"\\"+Constants.DISTRICT+"\\"+fileName));

				if (n != null) {
					success++;
				} else
					fail++;
			}
		}
		System.out.println("File Moved : "+success);
		System.out.println("File Failed to Moved : "+fail);
	}

}
