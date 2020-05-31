package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService bService;
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		
		return bService.findAll();
	}

	@RequestMapping("/findPage")
	public PageResult findPageResult(int page,int size) {
		 
		return bService.findPage(page, size);
	}

	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand tbBrand) {
		try {
			bService.add(tbBrand);
		return new Result("新增品牌成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result("新增品牌失败", false);
		}
	}
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return bService.findOne(id);
	}
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand tbBrand) {
		try {
			bService.update(tbBrand);
		return new Result("修改品牌成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result("修改品牌失败", false);
		}
	}
	@RequestMapping("/delete")
	public Result delete(Long[] longs) {
		try {
			bService.delete(longs);
		return new Result("删除品牌成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result("删除品牌失败", false);
		}
	}
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand,int page,int size) {
		return bService.findPage(tbBrand, page, size);
	}
	
	
	
}

