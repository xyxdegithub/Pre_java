package entity;

public class Goods {
	
         private Integer id;          //商品id
         private String goodsName;    //商品名称
         private String bigImg;       //商品大图
         private String indexImg;     //商品首展示图
         private String detail;       //商品详细介绍
         private String itro;         //商品首页介绍
         private Double price;        //商品价格
		public Goods() {
			
		}
		public Goods(Integer id, String goodsName, String bigImg, String indexImg, String detail, String itro,
				Double price) {
			super();
			this.id = id;
			this.goodsName = goodsName;
			this.bigImg = bigImg;
			this.indexImg = indexImg;
			this.detail = detail;
			this.itro = itro;
			this.price = price;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getGoodsName() {
			return goodsName;
		}
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		public String getBigImg() {
			return bigImg;
		}
		public void setBigImg(String bigImg) {
			this.bigImg = bigImg;
		}
		public String getIndexImg() {
			return indexImg;
		}
		public void setIndexImg(String indexImg) {
			this.indexImg = indexImg;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public String getItro() {
			return itro;
		}
		public void setItro(String itro) {
			this.itro = itro;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Goods [id=" + id + ", goodsName=" + goodsName + ", bigImg=" + bigImg + ", indexImg=" + indexImg
					+ ", detail=" + detail + ", itro=" + itro + ", price=" + price + "]";
		}
		
		
         
         
}
