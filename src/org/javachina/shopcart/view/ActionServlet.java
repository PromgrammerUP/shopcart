package org.javachina.shopcart.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javachina.shopcart.dto.GoodsInfoDto;
import org.javachina.shopcart.service.ShangpinService;

/**
 * Servlet implementation class ActionServlet
 */
//@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doRequest(request, response);
	}
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		if("buy".equals(act)){
			this.doGetByPage(request, response);
		}else if ("addToCart".equals(act)){
			this.doAddToCart(request, response);
		}else if("charge".equals(act)){
			this.charge(request,response);
		}
	
		}	
	private void charge(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		ArrayList<GoodsInfoDto> list = (ArrayList<GoodsInfoDto>)request.getSession().getAttribute("shopcart");
		for(int i=0;i<list.size();i++){
			GoodsInfoDto temp = list.get(i);
			for(int j=i+1;j<list.size();j++){
				GoodsInfoDto dto = list.get(j);
				if(temp.getId()==dto.getId()){
					int count = dto.getCount();
					temp.setCount(count+temp.getCount());
					list.remove(j);
				}
			}
		}
		request.getSession().setAttribute("shopcart", list);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
	/*
	 * 增加商品至购物车
	 */
	public void doAddToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] counts = request.getParameterValues("count");
		String[] ids = request.getParameterValues("id");
		String[] prices = request.getParameterValues("price");
		String[] names = request.getParameterValues("name");
		String[] nos = request.getParameterValues("no");
		Object obj = request.getSession().getAttribute("shopcart");
		ArrayList list = null;
		if(obj==null){
			list = new ArrayList();
		}else {
			list = (ArrayList)obj;
		}
		for (int i = 0; i < nos.length; i++) {//循环选中数据的角标
			int no = Integer.parseInt(nos[i]);//取出一个角标
			//根据角标到到数组中取得数据
			int id = Integer.parseInt(ids[no]);
			String name = names[no];
			double price = Double.parseDouble(prices[no]);
			int count = Integer.parseInt(counts[no]);
			GoodsInfoDto dto = new GoodsInfoDto();
			dto.setId(id);
			dto.setName(name);
			dto.setPrice(price);
			dto.setCount(count);
			list.add(dto);
		}
		request.getSession().setAttribute("shopcart",list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	public void doGetByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.取得参数
		int lid = Integer.parseInt(request.getParameter("leixingid"));
		
		//2.调用service取得该类型所对应的商品
		ShangpinService service = new ShangpinService();
		ArrayList all = service.getAllShangpin(lid);
		
		//3 分发页面
		request.setAttribute("all", all);
		
		request.getRequestDispatcher("/buy.jsp").forward(request, response);
		
	}
	}

