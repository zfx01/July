package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.*;
import com.july.demo.domain.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class OtherController {

    private String path=null;
    {
        try {
            path = ResourceUtils.getURL("classpath:").getPath()+"static/Source/";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    OtherControllerUsecase usecase;
    @Autowired
    AccessoryUsecase accessory;
    @Autowired
    AdminUsecase admin;
    @Autowired
    CommentUsecase comment;
    @Autowired
    DeclarationUsecase declaration;
    @Autowired
    ExpertUsecase expert;
    @Autowired
    ProjectUsecase project;
    @Autowired
    UserUsecase user;
    @Autowired
    VoteUsecase vote;
    @Autowired
    AwardUsecase award;
    @Autowired
    NoticeUsecase notice;

    @GetMapping("/")
    public String indexs(){
        return "index/index";
    }

    @GetMapping("page")
    public String page(@RequestParam String page){
        return page;
    }

    @GetMapping("page_review")
    public String page_id(Model model,@RequestParam String id,@RequestParam String page){
        model.addAttribute("id",id);
        model.addAttribute("data",project.findByid(id));
        return page;
    }

    @GetMapping("register")
    public String register_page(){
        return "registration";
    }



    @PostMapping("register")
    public String register(@RequestParam String username,@RequestParam String password,@RequestParam String email,@RequestParam String phone){

        usecase.register(new User(username,password,email,phone));
        return "login";
    }

    //获取邮箱验证码
    @ResponseBody
    @RequestMapping("getcode")
    public String getcode(@RequestParam String userto){
        return usecase.getcode(userto);
    }

    @GetMapping("login")
    public String login_page(){
        return "login";
    }

    @PostMapping("login")
    public String login(HttpServletRequest request,Model model,@RequestParam("email") String email,@RequestParam("password") String password ){
        System.out.println(email+password);
        HttpSession session= request.getSession();
        String id,username;
        try {
            Admin admins= admin.findUsernameAndPassword(email,password).get(0);
            id=admins.getId().getValue();
            username=admins.getUsername();
            model.addAttribute("username",username);
            model.addAttribute("id",id);
            if(admins.getRights().equals("root"))
                model.addAttribute("role","root");
            if(admins.getRights().equals("admin"))
                model.addAttribute("role","admin");
            session.setAttribute("username",username);
            session.setAttribute("id",id);
            if(!id.equals(""))
                return "index/index";
            else
                return "login";
        }catch (Exception e){}

        try {
            id= usecase.login(email,password);
            username= user.findByid(id).getUsername();
            model.addAttribute("username",username);
            model.addAttribute("id",id);
            model.addAttribute("role","user");
            session.setAttribute("username",username);
            session.setAttribute("id",id);
            if(!id.equals(""))
                return "index/index";
            else
                return "login";
        }catch (Exception e){}

        try {
            id= expert.findUsernameAndPassword(email,password).get(0).getId().getValue();
            username= expert.findByid(id).getUsername();
            model.addAttribute("username",username);
            model.addAttribute("id",id);
            model.addAttribute("role","expert");
            session.setAttribute("username",username);
            session.setAttribute("id",id);
            if(!id.equals(""))
                return "index/index";
            else
                return "login";
        }catch (Exception e){}

        return "login";

    }

    @RequestMapping("face")
    public String face(){
        return "face";
    }

    @RequestMapping("face2")
    public String face2(){
        return "face2";
    }

    //下载文件
    @ResponseBody
    @RequestMapping("download")
    private String downloadFile(HttpServletResponse response){
        String downloadFilePath = null;
        downloadFilePath = path+"test.docx";//被下载的文件在服务器中的路径,;
        String fileName = "test.docx";//被下载文件的名称
        File file = new File(downloadFilePath);
        System.out.println(downloadFilePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开            
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";

    }

    //上传文件

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            //log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            path = path + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    //获取图片
    @PostMapping("getimage")
    public String getimage(HttpServletRequest req,@RequestParam String card,@RequestParam MultipartFile file){
        String destFileName="";
        String card1=(String) req.getAttribute("card");
        MultipartFile file1=(MultipartFile) req.getAttribute("file");
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            destFileName= req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            destFileName= destFileName.split("static")[1];
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        System.out.println(destFileName);
        return "login";
    }

    @GetMapping("findpassword")
    public String findpassword(){
        return "findpassword";
    }

    @PutMapping("findpassword")
    public String findpasswordput(@RequestParam String password,@RequestParam String email){
        return usecase.changepassword(email,password);
    }

    @GetMapping("index")
    public String index(){
        return "index/index";
    }

    @GetMapping("back")
    public String back(){
        return "back/index";
    }

    @GetMapping("getpage")
    public String getpage(@RequestParam String page,Model model){
        String data;
        List list=new ArrayList();
        switch (page){
            case "user":
               list=user.getall();
               break;
            case "accessory":
                list=accessory.getall();
                break;
            case "admin":
                list=admin.getall();
                break;
            case "award":
                list=award.getall();
                break;
            case "comment":
                list=comment.getall();
                break;
            case "declaration":
                list=declaration.getall();
                break;
            case "expert":
                list=expert.getall();
                break;
            case "project":
                list=project.getall();
                break;
            case "vote":
                list=vote.getall();
                break;
            case "notice":
                list=notice.getall();
                break;
        }

       model.addAttribute("datas",list);
        return "back/"+page;
    }

    @GetMapping("getrole")
    public String getrole(@RequestParam  String id){
        if (id=="")
            return "login";
        try {
            admin.findByid(id);
            return "back/index";
        }catch (Exception e){

        }
        return "login";
    }

    @GetMapping("edit")
    public String edit(@RequestParam String type,String id,Model model,HttpServletRequest request){
        if(!id.equals("null")){
        Object obj=null;
        switch (type){
            case "user":
                obj=user.findByid(id);
                break;
            case "accessory":
                obj=accessory.findByid(id);
                break;
            case "admin":
                obj=admin.findByid(id);
                break;
            case "award":
                obj=award.findByid(id);
                break;
            case "comment":
                obj=comment.findByid(id);
                break;
            case "declaration":
                obj=declaration.findByid(id);
                break;
            case "expert":
                obj=expert.findByid(id);
                break;
            case "project":
                obj=project.findByid(id);
                break;
            case "vote":
                obj=vote.findByid(id);
                break;
            case "notice":
                obj=notice.findByid(id);
                break;
        }
        model.addAttribute("obj",obj);
        request.setAttribute("obj",obj);
        model.addAttribute("id",id);
            return "back/"+type+"_edit";
        }

        model.addAttribute("obj",null);
        request.setAttribute("obj",null);
        model.addAttribute("id",id);
        return "back/"+type+"_edit";

    }

    @GetMapping("getedit")
    public  String getedit(){
        return "back/admin_edit";
    }

    @GetMapping("expert_index")
    public String expert_index(Model model,String id){
        Expert expert_e=expert.findByid(id);
        String expertid=expert_e.getGroup();
        List<Award> list= award.findBygroup(expertid);
        List<Declaration> list1=new ArrayList<Declaration>();
        List<Projects> list2=new ArrayList<Projects>();

        for(int i=0;i<list.size();i++){
            list1.addAll(declaration.findByawardid(list.get(i).getId().getValue()));
        }
        for(int j=0;j<list1.size();j++){
            list2.add(project.findByid(list1.get(0).getProjectid()));
        }

        model.addAttribute("datas",list2);
            return "lzy/projects";
    }

    @GetMapping("review")
    public String review(@RequestParam String id,Model model){
        model.addAttribute("id",id);
        model.addAttribute("data",project.findByid(id));
        return "lzy/review";
    }

    @GetMapping("sessionid")
    public void session(HttpServletRequest request,@RequestParam String id){
        request.getSession().setAttribute("id",id);
    }

//    @GetMapping("obj_id")
//    public Object obj_id(String id,){
//        Object obj=null;
//        switch (type){
//            case "user":
//                obj=user.findByid(id);
//                break;
//            case "accessory":
//                obj=accessory.findByid(id);
//                break;
//            case "admin":
//                obj=admin.findByid(id);
//                break;
//            case "award":
//                obj=award.findByid(id);
//                break;
//            case "comment":
//                obj=comment.findByid(id);
//                break;
//            case "declaration":
//                obj=declaration.findByid(id);
//                break;
//            case "expert":
//                obj=expert.findByid(id);
//                break;
//            case "project":
//                obj=project.findByid(id);
//                break;
//            case "vote":
//                obj=vote.findByid(id);
//                break;
//            case "notice":
//                obj=notice.findByid(id);
//                break;
//        }
//        model.addAttribute("obj",obj);
//    }

    @GetMapping("user_index")
    public String user_index(@RequestParam String id, Model model){
        model.addAttribute("id",id);
        model.addAttribute("datas",project.findByower(id));
        return "projects";

    }

    @GetMapping("add_project")
    public String add_project(){
        return "add_project";
    }

    @GetMapping("admin_index")
    public String admin_index(@RequestParam String id,Model model){
        model.addAttribute("id",id);
        model.addAttribute("datas",project.getall());
        return "admin_index/projects";
    }

    @GetMapping("admin_review")
    public String admin_review(@RequestParam String id,Model model){
        model.addAttribute("id",id);
        model.addAttribute("data",project.findByid(id));
        return "admin_index/review";
    }

    @GetMapping("add_award")
    public String award(@RequestParam String id,Model model){
        model.addAttribute("id",id);
        return "add_award";
    }


    @GetMapping("getvotedata")
    @ResponseBody
    public List getvotedata(String id){

        List<Declaration> list=declaration.findByawardid(id);
        List<Comment> list1 = null;
        List<Integer> votes=new ArrayList<Integer>();
        for(int i=0;i<list.size();i++){
            int sum=0;
            list1=comment.getbyproject(list.get(i).getProjectid());
            for (int j=0;j<list1.size();j++){
                try {
                    sum=sum+Integer.valueOf(list1.get(j).getVote());
                }catch (Exception e){}

            }
            votes.add(sum);

        }

        return votes;

    }


    @GetMapping("findByawardid")
    @ResponseBody
    public  List<String> findByawardid(@RequestParam String id){
        List<Declaration> list= declaration.findByawardid(id);
        List<String> name=new ArrayList<String>();
        for (int i=0;i<list.size();i++){
            String id1= list.get(i).getProjectid();
            project.findByid(id1);
            name.add(project.findByid(list.get(i).getProjectid()).getName());
        }
        return name;
    }

    @GetMapping("chars")
    public String chars(){
        return "back/chars";
    }






}
