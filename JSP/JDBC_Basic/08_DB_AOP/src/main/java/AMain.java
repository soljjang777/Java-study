// 절차지향(if, for)
// 객체지향 (나눠지기 시작 => 분업 (정리, 유지보수)

// 새로운 패러다임
// 순서대로만 완성하던 실절 지나고 
// 실생활을 반영한 OOP(객체지향)

// ㅅ사실 OOP도 지났고 
//AOP(Aspect Oriented P) : 관점지향 프로그래밍 
// 절차 >> 객체 갔을때 처럼 확 바뀐건 아니고 객체지향을 조금 보완하는 정도

// ex) 사람이 학원, 학교, ..에 가는데 (객체지향)
// 잠에서 깨고, 세수, 머리, 옷, 신발, 지하철, ..
// 중복부분 빼자

//객체지향 하면서 조금만 더 생각하자
public class AMain {
	public static void main(String[] args) {
						
		//funtion
		//함수? 기능 반복할때
		
		Human h = new Human();
		h.goAcademy();
		System.out.println("----------");
		h.goSchool();
		
	}
}
