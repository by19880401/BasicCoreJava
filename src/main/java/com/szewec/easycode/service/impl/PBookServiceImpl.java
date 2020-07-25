package easycode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import easycode.dao.PBookDao;
import easycode.entity.PBook;
import easycode.service.PBookService;
import org.springframework.stereotype.Service;

/**
 * (PBook)表服务实现类
 *
 * @author makejava
 * @since 2020-07-25 18:23:03
 */
@Service("pBookService")
public class PBookServiceImpl extends ServiceImpl<PBookDao, PBook> implements PBookService {

}