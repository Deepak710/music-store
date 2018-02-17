package DMB.PRJ.MusicFront.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String ABS_PATH_PIC = "C:\\Users\\Deepak\\Documents\\Project\\music-store\\MusicFront\\src\\main\\webapp\\assets\\images\\";
	private static final String ABS_PATH_SONG = "C:\\Users\\Deepak\\Documents\\Project\\music-store\\MusicFront\\src\\main\\webapp\\assets\\audios\\";
	private static String REAL_PATH = null;
	private static final Logger l = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadPic(HttpServletRequest req, MultipartFile file, String pic) {
		REAL_PATH = req.getSession().getServletContext().getRealPath("/assets/images/");
		l.info(REAL_PATH);
		if (!new File(ABS_PATH_PIC).exists()) {
			new File(ABS_PATH_PIC).mkdirs();
		}
		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		try {
			file.transferTo(new File(REAL_PATH + pic));
			file.transferTo(new File(ABS_PATH_PIC + pic));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void uploadSong(HttpServletRequest req, MultipartFile file, String song) {
		REAL_PATH = req.getSession().getServletContext().getRealPath("/assets/audios/");
		if (!new File(ABS_PATH_SONG).exists()) {
			new File(ABS_PATH_SONG).mkdirs();
		}
		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		try {
			file.transferTo(new File(REAL_PATH + song));
			file.transferTo(new File(ABS_PATH_SONG + song));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
