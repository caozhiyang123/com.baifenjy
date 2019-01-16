package cn.itcast.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.web.service.OrderServiceImpl;
import cn.itcast.web.vo.EasyUIResult;

@Controller
@RequestMapping("page")
public class OrderController {

    @Autowired
    private OrderServiceImpl itemServiceImpl;

    @RequestMapping(value="/item/pageQuery",method=RequestMethod.GET)
    public ResponseEntity<EasyUIResult> pageQuerySorted(@RequestParam("page")Integer pageNum,@RequestParam("rows")Integer pageSize
            ,@RequestParam(value="sort",required=false,defaultValue="updated")String sort,
            @RequestParam(value="order",required=false,defaultValue="DESC")String order){
        try {
            if(pageNum<0 || pageSize<0){
                //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            PageInfo<Item> pageInfo = itemServiceImpl.queryPageSorted(null, pageNum, pageSize, sort,order);
            EasyUIResult result = new EasyUIResult();
            result.setTotal(Integer.parseInt(Long.toString(pageInfo.getTotal())));
            result.setRows(pageInfo.getList());
            if(result==null){
                //资源转移404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
            }
            //查询成功
            return  ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            e.printStackTrace();
        }  
        //服务器异常
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        
    }


    @RequestMapping(value="/item/insert",method=RequestMethod.POST)//
    public ResponseEntity<Void> insertIntem(Item item,@RequestParam("desc")String desc,@RequestParam("itemParams")String itemParams
            ){
        try {
            if(item==null){
                //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            item.setStatus(1);
            Integer info = itemServiceImpl.save(item,desc,itemParams);
            if(info!=1){
                //服务器有异常500
                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            //保存数据成功201
            return  ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //服务器有异常500
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }



    @RequestMapping(value="/pic/upload",method=RequestMethod.POST)
    public ResponseEntity<String> upLoadImage(@RequestParam("uploadFile")MultipartFile picturePicture){
        try {
            if(picturePicture!=null){
                picturePicture.transferTo(new File("c:\\tmp\\"+picturePicture.getOriginalFilename()));
                return  ResponseEntity.status(HttpStatus.OK).body("c:\\tmp\\"+picturePicture.getOriginalFilename());
            }
        } catch  (IOException e) {
            e.printStackTrace();
        }
        //服务器有异常500
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("c:\\tmp\\"+picturePicture.getOriginalFilename());
    }

    @RequestMapping(value="/item/edit",method=RequestMethod.PUT)
    public ResponseEntity<Void> editItem(Item item,@RequestParam("itemParamId")Long itemParamId
           , @RequestParam("desc")String desc,@RequestParam("itemParams")String itemParams ){
        try {
            if(item==null||item.getId()==null){
                //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Integer info = itemServiceImpl.updateItemSelective(item,desc,itemParamId,itemParams);
            if(info!=1){
                //服务器有异常500
                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            //修改数据成功204
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //服务器有异常500
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @RequestMapping(value="/item/desc",method=RequestMethod.GET)
    public ResponseEntity<ItemDesc> queryDesc(@RequestParam("id")Long id){
        try {
            if(id==null){
              //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            ItemDesc itemDesc = itemDescService.queryById(id);
            if(itemDesc==null){
                //资源转移404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            //查询成功
            return  ResponseEntity.status(HttpStatus.OK).body(itemDesc);
        } catch (Exception e) {
            e.printStackTrace();
        }
      //服务器异常
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    @RequestMapping(value="/item/instock",method=RequestMethod.PUT)
    public ResponseEntity<Void> instock(@RequestParam("ids")List<Object> ids){
        try {
            if(ids==null||ids.size()==0){
              //参数列表错误400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Integer info = itemServiceImpl.instock(ids);
            if(info<0){
                //服务器有异常500
                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            //修改数据成功204
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //服务器异常
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
        
        @RequestMapping(value="/item/reshelf",method=RequestMethod.PUT)
        public ResponseEntity<Void> reshelf(@RequestParam("ids")List<Object> ids){
            try {
                if(ids==null||ids.size()==0){
                    //参数列表错误400
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
                Integer info = itemServiceImpl.reshelf(ids);
                if(info<0){
                    //服务器有异常500
                    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
                //修改数据成功204
                return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //服务器异常
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            
    }
        @RequestMapping(value="/item/delete",method=RequestMethod.DELETE)
        public ResponseEntity<Void> delete(@RequestParam("ids")List<Object> ids){
            try {
                if(ids==null||ids.size()==0){
                    //参数列表错误400
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
                Integer info = itemServiceImpl.deleteByExampleService("id", ids);
                if(info<0){
                    //服务器有异常500
                    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
                //修改数据成功204
                return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //服务器异常
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            
        }
        
        
    
}
