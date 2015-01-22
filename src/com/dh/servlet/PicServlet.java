// Search Engine Demo for DHGate.com 
// Author: Shen Jiyi  shenjiyi@dhgate.com
// 2015.1.19

package com.dh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dh.domain.PicItem;
import com.dh.domain.Piclight;
import com.dh.util.SearchUtil;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

/**
 * Servlet implementation class PicServlet
 */
@WebServlet("/pic/get")
public class PicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String imgUrl=request.getParameter("img");
		String type=request.getParameter("optionsRadiosinline");
		
		String regex1 = "http.*://.*";		
		Boolean flag=Pattern.matches(regex1, imgUrl);
		
//		String postUrl = SearchUtil
//				.getSearchStr("http://www.dhresource.com/albu_880404138_00/1.0x0.jpg");
		String postUrl=null;
		if(flag){
			postUrl = SearchUtil
					.getSearchStr(imgUrl,Integer.parseInt(type));
		}
		else{
			postUrl= SearchUtil.getSearchStr2(imgUrl, Integer.parseInt(type));
		}

		System.out.println(imgUrl);
		System.out.println(flag);
		System.out.println(postUrl);
		
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

		Request req = new RequestBuilder()
				.setUrl("http://localhost/piclight/query")
				.addQueryParameter("json", postUrl).build();

		Future<Response> f = asyncHttpClient.prepareRequest(req).execute();

		try {
			Response r = f.get();

			Piclight piclight = JSON.parseObject(r.getResponseBody(),
					Piclight.class);
			
	//		response.getWriter().println(r.getResponseBody());
			
			List<PicItem> pics=piclight.getContent();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>"); 
			out.println("<head>"); 
			out.println("<title>Result</title>");	
			out.println("</head>");
			out.println("<body>");
			
			String featureType[] = {"ScalableColor","ColorLayout","CEDD","PHOG","EdgeHistogram"};
			if(flag)
			{
				response.getWriter().println("<img src="+"'"+imgUrl+"'"+"width=500"+"/>");
			}

			response.getWriter().println("<p>"+"type="+featureType[Integer.parseInt(type)]+"</p>");
			
			for(PicItem picItem:pics){
					response.getWriter().println("<p>"+"distance = "+picItem.getD()+"  ID="+picItem.getId()+"</p>");
					response.getWriter().println("<img src="+"'"+picItem.getUrl()+"'"+"width=500"+"/>");
				}
			out.println("</body>");
			out.println("</html>");
	//		request.setAttribute("result", pics);
	//		request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} catch (Exception e) {

		}
	}
}
