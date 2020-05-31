package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import util.LylValidateUtils;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {
		
		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int pageNum, int rows) {
		
		PageHelper.startPage(pageNum, rows);//分页
		
		Page<TbBrand>  page=(Page<TbBrand>) brandMapper.selectByExample(null);
		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void add(TbBrand tbBrand) {
		brandMapper.insert(tbBrand);
	}

	@Override
	public TbBrand findOne(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand tbBrand) {
		brandMapper.updateByPrimaryKey(tbBrand);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public PageResult findPage(TbBrand tbBrand, int pageNum, int rows) {
		
		PageHelper.startPage(pageNum, rows);//分页
		TbBrandExample tbBrandExample=new TbBrandExample();
		Criteria criteria = tbBrandExample.createCriteria();
		if (tbBrand!=null) {
			if (!LylValidateUtils.isEmpty(tbBrand.getName())) {
				criteria.andNameLike("%"+tbBrand.getName()+"%");
			}
			if (!LylValidateUtils.isEmpty(tbBrand.getFirstChar())) {
				criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
			}
		}
		
		Page<TbBrand>  page=(Page<TbBrand>) brandMapper.selectByExample(tbBrandExample);
		
		return new PageResult(page.getTotal(),page.getResult());
	}
	
	

}
