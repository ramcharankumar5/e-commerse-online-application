package net.god.onlineapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.god.shoppingBckend.Dao.CategoryDAO;
import net.god.shoppingBckend.Dto.Category;

@Controller
public class Pagecontroller {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("title", "Home");
		
		//PASSING THE LIST OF THECATEGORIES
		
		model.addObject("categories", categoryDAO.list());
		model.addObject("userClickHome", true);
		return model;
	}
	
	
	@RequestMapping(value="about")
	public ModelAndView about()
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("title", "About us");
		model.addObject("userClickAbout", true);
		return model;
	}
	

	@RequestMapping(value="contact")
	public ModelAndView contact()
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("title", "Contact us");
		model.addObject("userClickContact", true);
		return model;
	}
	

	
	//psiing the products
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("title", "All Products");
		
		//PASSING THE LIST OF THECATEGORIES
		
		model.addObject("categories", categoryDAO.list());
		model.addObject("userClickAllProducts", true);
		return model;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView model=new ModelAndView("page");
		
		
		// category Dao to fetach single category
		Category category=null;
		
		category=categoryDAO.get(id);
		model.addObject("title", category.getName());
		
		//PASSING THE LIST OF THE CATEGORIES
		
		model.addObject("categories", categoryDAO.list());
		
		//passing the single object
		
		model.addObject("category", category);

		model.addObject("userClickCategoryProducts", true);
		return model;
	}
	
	
	
	

}
