package dto;

public class TeamArticleBean implements java.io.Serializable{
   private static final long serialVersionUID = 1L;
   
   private String team_name;
   private String news_url;
   private String news_title;
   private String news_abstract_content;
   private String image_url;
   
   public TeamArticleBean() {
      super();
   }

   public TeamArticleBean(String team_name, String news_url, String news_title, String news_abstract_content,
         String image_url) {
      super();
      this.team_name = team_name;
      this.news_url = news_url;
      this.news_title = news_title;
      this.news_abstract_content = news_abstract_content;
      this.image_url = image_url;
   }


   public String getTeam_name() {
      return team_name;
   }

   public void setTeam_name(String team_name) {
      this.team_name = team_name;
   }

   public String getNews_url() {
      return news_url;
   }

   public void setNews_url(String news_url) {
      this.news_url = news_url;
   }

   public String getImage_url() {
      return image_url;
   }

   public void setImage_url(String image_url) {
      this.image_url = image_url;
   }
   
   public String getNews_title() {
      return news_title;
   }

   public void setNews_title(String news_title) {
      this.news_title = news_title;
   }

   public String getNews_abstract_content() {
      return news_abstract_content;
   }

   public void setNews_abstract_content(String news_abstract_contetn) {
      this.news_abstract_content = news_abstract_contetn;
   }

   @Override
   public String toString() {
      return "TeamArticleBean [team_name=" + team_name + ", news_url=" + news_url + ", news_title=" + news_title
            + ", news_abstract_contetn=" + news_abstract_content + ", image_url=" + image_url + "]";
   }

   
   
   
}