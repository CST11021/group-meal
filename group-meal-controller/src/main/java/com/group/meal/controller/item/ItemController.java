package com.group.meal.controller.item;

import com.group.meal.dao.dataobject.GroupItemDO;
import com.group.meal.result.BaseResult;
import com.group.meal.result.PageResult;
import com.group.meal.result.http.HttpResponsePageResult;
import com.group.meal.service.local.item.ItemService;
import com.group.meal.util.base.BaseUtil;
import com.group.meal.util.item.ItemUtil;
import com.group.meal.vo.item.ItemQueryVO;
import com.group.meal.vo.item.ItemResultVO;
import com.group.meal.vo.item.ItemSaveVO;
import com.group.meal.vo.item.ItemUpdateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @authod wb-whz291815
 * @create 2017/9/25 23:41
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/manager")
    public ModelAndView query() {
        return new ModelAndView("/item/itemManager");
    }

    @ResponseBody
    @RequestMapping("/query")
    public HttpResponsePageResult<List<ItemResultVO>> query(@RequestParam(value = "categoryIds[]", required = false) Long[] categoryIds,
                                                             @RequestParam(value = "skuName", required = false) String skuName,
                                                             @RequestParam(value = "status", required = false) Byte status) {

        PageResult<List<GroupItemDO>> pageResult = itemService.queryPageByCondition(categoryIds, skuName, status);
        return ItemUtil.convert(pageResult);
    }

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult save(ItemSaveVO saveVO) {
        return null;
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(ItemUpdateVO updateVO) {
        return null;
    }

    @ResponseBody
    @RequestMapping("/mulDelete")
    public BaseResult mulDelete(@RequestParam("ids[]") Long[] ids) {
        return null;
    }

    @RequestMapping("/exportItem")
    public void exportItem(ItemQueryVO queryVO, HttpServletRequest request, HttpServletResponse response) {

    }


}
