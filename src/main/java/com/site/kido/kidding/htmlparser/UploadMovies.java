package com.site.kido.kidding.htmlparser;

import com.site.kido.kidding.service.MovieService;
import com.site.kido.kidding.utils.DateTimeUtils;
import com.site.kido.kidding.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/18.
 */

@Service
public class UploadMovies {

    @Autowired
    private MovieService movieService;

    public void uploadMoviesFile() {
        String path = "/Users/chendianshu/learncode/素材/dianyings";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory() && !f.getName().equals(".DS_Store")) { //若非目录(即文件)，则打印
                MovieVO movieVO = uploadFile(f);
                System.out.println(f.getName() + ":" + movieService.insert(movieVO));
            }

        }
    }

    public MovieVO uploadFile(File file) {
        BufferedReader reader = null;
        MovieVO movieVO = new MovieVO();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            for (int line = 1; line <= 7; line++) {
                tempString = reader.readLine();
                if (line == 1) {
                    movieVO.setDoubanLink(tempString.trim());
                }
                if (line == 2) {
                    movieVO.setCnName(tempString.trim());
                }
                if (line == 3) {
                    movieVO.setReleaseDate(DateTimeUtils.stringToTimestamp(tempString.replaceAll("-", "")));
                }
                if (line == 4) {
                    movieVO.setType(Integer.valueOf(tempString.trim()));
                }
                if (line == 5) {
                    movieVO.setDownloadLink(tempString.trim());
                }
                if (line == 6) {
                    movieVO.setCover(tempString.trim());
                }
                if (line == 7) {
                    List<String> lines = new ArrayList<>();
                    lines.add(tempString.trim());
                    movieVO.setLines(lines);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e1) {
                }
            }
            return movieVO;
        }

    }
}
