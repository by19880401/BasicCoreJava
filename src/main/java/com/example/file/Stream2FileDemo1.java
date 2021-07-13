package com.example.file;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;

/**
 * InputStream转File
 * 第一种方式：使用FileUtils.copyInputStreamToFile()
 * 会生成临时文件，转化完成之后是要删除临时文件的，临时文件只起到了过渡的作用
 */
public class Stream2FileDemo1 {
    private static final Log LOGGER = LogFactory.get();

    public static void main(String[] args) throws IOException {
        // 设置将要生成的目标文件目录
        ClassPathResource tempResource = new ClassPathResource("template");
        String tempPath = tempResource.getFile().getAbsolutePath() + File.separator + System.currentTimeMillis() + "_file.xlsx";
        LOGGER.info("要生成的临时文件路径：{}", tempPath);
        // 将要生成的目标文件
        File tempFile = new File(tempPath);

        // 假设：我们得到了一个multipartFile，这种类型的文件，我们通常会通过上传文件获得application/form-data
        MultipartFile multipartFile = getFile();

        // InputStream转file
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), tempFile);

        LOGGER.info("生成了文件：{}", tempFile.getAbsoluteFile());

        // 操作完上的文件 需要删除在根目录下生成的文件
        String tempFileName = tempFile.getName();
        if (tempFile.delete()) {
            LOGGER.info("删除{}成功", tempFileName);
        } else {
            LOGGER.info("删除{}失败", tempFileName);
        }
    }

    /**
     * 模拟MultipartFile的生成，并返回
     *
     * @return
     * @throws IOException
     */
    public static MultipartFile getFile() throws IOException {
        String filePath = "template" + File.separator + "template_excel.xlsx";
        ClassPathResource resource = new ClassPathResource(filePath);
        File file = resource.getFile();
        FileItem fileItem = new DiskFileItem("copyTemplateFile.txt", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
        byte[] buffer = new byte[4096];
        int n;
        try (InputStream inputStream = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            while ((n = inputStream.read(buffer, 0, 4096)) != -1) {
                os.write(buffer, 0, n);
            }
            //也可以用IOUtils.copy(inputStream,os);
            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
            LOGGER.info("multipartFile name:{}", multipartFile);
            return multipartFile;
        } catch (IOException e) {
            LOGGER.warn("Exception occurs!", e);
        }
        return null;
    }
}
