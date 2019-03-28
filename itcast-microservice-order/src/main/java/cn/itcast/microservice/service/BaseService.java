package cn.itcast.microservice.service;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.microservice.pojo.BasePojo;
import cn.itcast.microservice.util.ThreadLocalSimple;

public abstract class BaseService<T extends BasePojo>
{
    /*private Mapper<T> mapper;
  
  public abstract Mapper getMapper();
  
  public BaseService() {
      mapper = this.getMapper();
  }*/
    
    @Autowired
    private Mapper<T> mapper;
    
    private Class<T> clazz;
    
    {
       //初始化T
       //通过泛型T的子类Class对象获取父类参数化类型对象
       ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
       //通过参数化类型对象调用方法-，获取真实的类型参数对象
       clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
    
    
    /**
     * 有序的分页查询，如是无条件的分页查询record传入null即可
     * @param record
     * @param page
     * @param rows
     * @param order 
     * @return
     * @throws Exception 
     */
    public PageInfo<T> queryPageSorted(T record,Integer page,Integer rows,String sort, String order) throws Exception{
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(page, rows);
        Example example = new Example(clazz);
        if(StringUtils.isNotBlank(sort)&&StringUtils.isNotBlank(order)){
            example.setOrderByClause(sort+" "+order);            
        }
        List<T> list = this.mapper.selectByExample(example);
        return new PageInfo<T>(list);
    }
    
    /**
     * 新增数据，包括Null
     * @param record
     * @return
     */
    public Integer insert(T record){
        String time = ThreadLocalSimple.df.get().format(new Date());
        record.setCreated(time);
        record.setUpdated(time);
        return this.mapper.insert(record);
    }
    
    /**
     * 新增数据，不包括null
     * @param record
     * @return
     */
    public Integer insertSelective(T record){
        String time = ThreadLocalSimple.df.get().format(new Date());
        record.setCreated(time);
        record.setUpdated(time);
        return this.mapper.insertSelective(record);
    }
    
    /**
     * 更据主键更新数据,包括null
     * @param record
     * @return
     */
    public Integer update(T record){
        String time = ThreadLocalSimple.df.get().format(new Date());
        record.setCreated(null);
        record.setUpdated(time);
        return this.mapper.updateByPrimaryKey(record);
    }
    
    
    
    /**
     *根据主键更新数据，不包括null
     * @param record
     * @return
     */
    public Integer updateSelective(T record){
        String time = ThreadLocalSimple.df.get().format(new Date());
        record.setCreated(null);
        record.setUpdated(time);
        return this.mapper.updateByPrimaryKeySelective(record);
    }
    
    /**根据条件删除
     * 
     * @param record
     * @return
     */
    public Integer deleteByCriteria(T record){
        return this.mapper.delete(record);
    }
    
    /**
     * 根据主键批量删除
     * @param info
     * @param ids
     * @return
     */
    public Integer deleteByExample(String info,List<Object> ids){
        Example example = new Example(clazz);
        Criteria criteria = example.createCriteria();
        criteria.andIn(info, ids);
        return this.mapper.deleteByExample(example);        
    }
}
