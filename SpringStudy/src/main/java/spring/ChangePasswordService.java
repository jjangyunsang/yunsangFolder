package spring;

public class ChangePasswordService {
    private MemberDao memberDao;

    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) { // 회원정보 없음.
            throw new MemberNotFoundException();
        }

        // 비밀번호 업데이트
        member.changePassword(oldPwd, newPwd); // 비밀번호확인 및 업데이트
        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) { // 의존하는 MemberDao를 전달 받는다. (= 의존 객체를 주입받는다)
        this.memberDao = memberDao;
    }
}
