package cn.tqktqk.spring.springbootmybatisplus.service.impl;

import cn.tqktqk.spring.springbootmybatisplus.entity.MpUser;
import cn.tqktqk.spring.springbootmybatisplus.dao.MpUserMapper;
import cn.tqktqk.spring.springbootmybatisplus.service.IMpUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tuqikang
 * @since 2019-04-08
 */
@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements IMpUserService {

}
