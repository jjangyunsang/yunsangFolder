package spring;

// 세터 메서드를 이용해서 의존 객체를 주입받는 코드 예제
public class MemberInfoPrinter {
    private MemberDao memDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memDao = memberDao;
    }

    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }
}
