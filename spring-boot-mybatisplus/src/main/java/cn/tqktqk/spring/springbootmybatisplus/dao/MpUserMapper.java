package cn.tqktqk.spring.springbootmybatisplus.dao;

import cn.tqktqk.spring.springbootmybatisplus.entity.MpUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tuqikang
 * @since 2019-04-08
 */
@Mapper
public interface MpUserMapper extends BaseMapper<MpUser> {

}
