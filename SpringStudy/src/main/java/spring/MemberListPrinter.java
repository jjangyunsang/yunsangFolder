package spring;

import java.util.Collection;

public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter printer;

    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
        this.memberDao = memberDao;
        this.printer = printer;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> printer.print(m)); // foreach
        if (members.size() == 0) {
            System.out.println("데이터가 없습니다.");
        }
    }
}
