package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/jsp/include/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/fns.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>首页</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"nav-at-0\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"page-header\">\r\n");
      out.write("\t\t<h1>\r\n");
      out.write("\t\t\trestjplat - quickweb <small>例子说明</small>\r\n");
      out.write("\t\t</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<h2>业务场景</h2>\r\n");
      out.write("\t<p>当一个项目中包含有web服务（rest）时，当遇见异常时，需要返回给客户端json格式的数据；但是项目中非web服务的异常则需要正常处理的情况。</p>\r\n");
      out.write("\t<p>即同一个web项目中包含两种不同的异常处理。</p>\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<h2>简单说明</h2>\r\n");
      out.write("\t<p>直接使用Spring MVC架构web服务 ，目前只支持json返回值</p>\r\n");
      out.write("\t<p>1.所有产生异常先经过restservice-servlet.xml中注册的rest服务异常类处理</p>\r\n");
      out.write("\t<pre class=\"prettyprint\">\t\r\n");
      out.write("\t\t&lt;bean id=&quot;RestServiceExceptionHandler&quot;\r\n");
      out.write("\t\tclass=&quot;com.restjplat.quickweb.web.restServer.AppExceptionHandler&quot;&gt;\r\n");
      out.write("\t\t&lt;property name=&quot;order&quot; value=&quot;1&quot; /&gt;\r\n");
      out.write("\t\t&lt;property name=&quot;errorResolver&quot;&gt;\r\n");
      out.write("\t\t\t&lt;bean class=&quot;com.restjplat.core.webserver.DefaultRestErrorResolver&quot;&gt;\r\n");
      out.write("\t\t\t\t&lt;property name=&quot;exceptionMappingDefinitions&quot;&gt;\r\n");
      out.write("\t\t\t\t\t&lt;map&gt;\r\n");
      out.write("\t\t\t\t\t\t&lt;entry key=&quot;com.restjplat.core.webserver.RestServiceException&quot;\r\n");
      out.write("\t\t\t\t\t\t\tvalue=&quot;404&quot; /&gt;\r\n");
      out.write("\t\t\t\t\t\t&lt;entry key=&quot;Throwable&quot; value=&quot;500&quot; /&gt;\r\n");
      out.write("\t\t\t\t\t&lt;/map&gt;\r\n");
      out.write("\t\t\t\t&lt;/property&gt;\r\n");
      out.write("\t\t\t&lt;/bean&gt;\r\n");
      out.write("\t\t&lt;/property&gt;\r\n");
      out.write("\t&lt;/bean&gt;\r\n");
      out.write("\t</pre>\r\n");
      out.write("\t\r\n");
      out.write("\t<p>2.在 AppExceptionHandler 类中判断异常是否为rest异常，如果不是，则交给下一级异常处理。</p>\r\n");
      out.write("\t\r\n");
      out.write("\t<pre class=\"prettyprint\">\t\r\n");
      out.write("\t//resources.properties 文件内定义了 凡是以 /rv1开头的请求就是rest服务\r\n");
      out.write("\t@Override\r\n");
      out.write("\tpublic boolean isRestServiceException(HttpServletRequest request){\r\n");
      out.write("\t\tif(request.getServletPath().startsWith(Sysutils.getWebServerindex())) return true;\r\n");
      out.write("\t\telse return false;\r\n");
      out.write("\t}\r\n");
      out.write("\t</pre>\r\n");
      out.write("\r\n");
      out.write("\t<p>3. 非rest异常则直接由spring处理</p>\r\n");
      out.write("\t<pre class=\"prettyprint\">\r\n");
      out.write("\t\t<!-- 将Controller抛出的异常转到特定View,保持SiteMesh的装饰效果 ,\r\n");
      out.write("\t并且该resolver的order大于rest服务error的梳理顺序 ,即所有的异常先过一遍rest-->\r\n");
      out.write("\t&lt;bean\r\n");
      out.write("\t\tclass=&quot;org.springframework.web.servlet.handler.SimpleMappingExceptionResolver&quot;&gt;\r\n");
      out.write("\t\t&lt;property name=&quot;exceptionMappings&quot;&gt;\r\n");
      out.write("\t\t\t&lt;props&gt;\r\n");
      out.write("\t\t\t\t&lt;prop key=&quot;java.lang.Throwable&quot;&gt;error/500&lt;/prop&gt;\r\n");
      out.write("\t\t\t&lt;/props&gt;\r\n");
      out.write("\t\t&lt;/property&gt;\r\n");
      out.write("\t&lt;/bean&gt;\r\n");
      out.write("\t</pre>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("ctxStatic");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}/static", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }
}
