package edu.pnu.domain;

	import java.util.Date;

	public class memberVO {

		int id;
		String pass;
		String name;
		Date regidate;
		
		public memberVO() {
			// 기본생성자
			System.out.println("memberVO 기본생성자입니다.");
		}
		
		public memberVO(int id, String pass, String name, Date regidate) {
//			super();
			this.id = id;
			this.pass = pass;
			this.name = name;
			this.regidate = regidate;
		}
//		
//		public memberVO(String pass, String name, Date regidate) {
////			super();
//			this.pass = pass;
//			this.name = name;
//			this.regidate = regidate;
//		}
//		

		@Override
		public String toString() {
			return "memberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
		}
		

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getRegidate() {
			return regidate;
		}
		public void setRegidate(Date regidate) {
			this.regidate = regidate;
		}
		
		
	}

