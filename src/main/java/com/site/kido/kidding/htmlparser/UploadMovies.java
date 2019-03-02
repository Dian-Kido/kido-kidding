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

    private static final String COVER_PRE = "/images/movieCovers/";
    private static final String COVER_FILETYPE = ".jpg";

    public void uploadMoviesFile() {
        String path = "/root/kido-datas/dianyings";        //要遍历的路径
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

            for (int line = 1; line <= 8; line++) {
                tempString = reader.readLine();
                if (line == 1) {
                    movieVO.setDoubanLink(tempString.trim());
                }
                if (line == 2) {
                    movieVO.setCnName(tempString.trim());
                    movieVO.setCover(COVER_PRE + tempString.trim() + COVER_FILETYPE);
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
                    List<String> lines = new ArrayList<>();
                    lines.add(tempString.trim());
                    movieVO.setLines(lines);
                }
                if (line == 7) {
                    movieVO.setPlayLink(tempString.trim());
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

    //添加或者更新播放链接
    public void addMoviesPlay(List<String> playsList) {

        for (String strline : playsList) {

            MovieVO movieVO = new MovieVO();
            String str[] = strline.split("\t");

            System.out.println(str[0] + "|" + str[1]);

            movieVO.set_id(str[0]);
            movieVO.setPlayLink(str[1]);

            System.out.println("movie update result:" + movieService.update(movieVO, movieVO.get_id()));

            try {
                Thread.sleep(5);
            } catch (Exception e) {

            }

        }
    }

}
