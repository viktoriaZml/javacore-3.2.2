import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
  private final String date;
  private final String explanation;
  private final String hdUrl;
  private final String mediaType;
  private final String serviceVersion;
  private final String title;
  private final String url;

  public Image(@JsonProperty("date") String date
          ,@JsonProperty("explanation")  String explanation
          ,@JsonProperty("hdurl")  String hdUrl
          ,@JsonProperty("media_type")  String mediaType
          ,@JsonProperty("service_version")  String serviceVersion
          ,@JsonProperty("title")  String title
          ,@JsonProperty("url")  String url) {
    this.date = date;
    this.explanation = explanation;
    this.hdUrl = hdUrl;
    this.mediaType = mediaType;
    this.serviceVersion = serviceVersion;
    this.title = title;
    this.url = url;
  }

  public String getDate() {
    return date;
  }

  public String getExplanation() {
    return explanation;
  }

  public String getHdUrl() {
    return hdUrl;
  }

  public String getMediaType() {
    return mediaType;
  }

  public String getServiceVersion() {
    return serviceVersion;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  @Override
  public String toString() {
    return "Image{" +
            "date='" + date + '\'' +
            ", explanation='" + explanation + '\'' +
            ", hdUrl='" + hdUrl + '\'' +
            ", mediaType='" + mediaType + '\'' +
            ", serviceVersion='" + serviceVersion + '\'' +
            ", title='" + title + '\'' +
            ", url='" + url + '\'' +
            '}';
  }
}
