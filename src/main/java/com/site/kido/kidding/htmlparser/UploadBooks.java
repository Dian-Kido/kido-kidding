package com.site.kido.kidding.htmlparser;

import com.site.kido.kidding.service.BookService;
import com.site.kido.kidding.utils.DateTimeUtils;
import com.site.kido.kidding.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 上传DOCS/books 下的书本信息到数据库
 *
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/20.
 */
@Service
public class UploadBooks {

    @Autowired
    private BookService bookService;

    private static final String COVER_PRE = "/images/bookCovers/";
    private static final String COVER_FILETYPE = ".jpg";

    public void uploadBooksFile() {
        String path = "/Users/chendianshu/learncode/素材/books";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory() && !f.getName().equals(".DS_Store")) { //若非目录(即文件)，则打印
                BookVO bookVO = uploadFile(f);
                System.out.println(f.getName() + ":" + bookService.insert(bookVO));
            }

        }
    }

    public BookVO uploadFile(File file) {
        BufferedReader reader = null;
        BookVO bookVO = new BookVO();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            for (int line = 1; line <= 7; line++) {
                tempString = reader.readLine();
                if (line == 1) {
                    bookVO.setDoubanLink(tempString.trim());
                }
                if (line == 2) {
                    bookVO.setCnName(tempString.trim());
                    bookVO.setCover(COVER_PRE + tempString.trim() + COVER_FILETYPE);
                }
                if (line == 3) {
                    bookVO.setAuthor(tempString.trim());
                }
                if (line == 4) {
                    bookVO.setReadDate(DateTimeUtils.stringToTimestamp(tempString.replaceAll("-", "")));
                }
                if (line == 5) {
                    List<String> lines = new ArrayList<>();
                    lines.add(tempString.trim());
                    bookVO.setLines(lines);
                }
                if (line == 6) {
                    bookVO.setRecommendIndex(Integer.valueOf(tempString.trim()));
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
            return bookVO;
        }

    }
}
