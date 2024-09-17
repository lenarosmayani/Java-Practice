package Repository;

import java.util.ArrayList;
import java.util.List;

import Entity.Member;
import Main.ConsoleUser;
import ValidasiInput.InputValidator;

public class RepositoryMember {
    private List<Member> memberList;
    private final DisplayRepository displayRepository;
    private static final String MEMBER_ID_PREFIX = "M-";
    private static int memberCounter = 0;

    public RepositoryMember() {
        this.memberList = new ArrayList<>();
		this.displayRepository = new DisplayRepository();
        memberList.add(new Member("M-001", "Risman", "Bandung"));
        memberList.add(new Member("M-002", "Budi", "Bandung"));
        memberList.add(new Member("M-003", "Resti", "Kab. Bandung"));
    }

    public List<Member> getAllMember() {
        return memberList;
    }

    public Member getMemberNameByID(String memberID) {
    	String cleanedMemberID = memberID.replaceAll("\\s", "");
    	
        for (Member member : memberList) {
            if (member.getMemberID().equalsIgnoreCase(cleanedMemberID)) {
                return member;
            }
        }
        return null;
    }

    public void addNewMember(String newMemberID, String newMemberName, String newMemberAddress) {

        Member newMember = new Member(newMemberID, newMemberName, newMemberAddress);
        memberList.add(newMember);

        System.out.println("Member baru berhasil ditambahkan!");
    }
    
    public void addNewMember(ConsoleUser consoleUI) {
        String newMemberName = consoleUI.getUserInput("Masukkan Nama Member Baru: ", InputValidator.getStringValidator());
        String newMemberAddress = consoleUI.getUserInput("Masukkan Alamat Member Baru: ", InputValidator.getStringValidator());
        String newMemberID = generateUniqueMemberID();

        addNewMember(newMemberID, newMemberName, newMemberAddress);
        consoleUI.showMessage("Member " + newMemberName + " berhasil terdaftar dengan ID: " + newMemberID);
    }

    public String generateUniqueMemberID() {
        String newMemberID;
        do {
            memberCounter++;
            newMemberID = MEMBER_ID_PREFIX + String.format("%03d", memberCounter);
        } while (isMemberIDExists(newMemberID));

        return newMemberID;
    }

    private boolean isMemberIDExists(String memberID) {
        for (Member member : memberList) {
            if (member.getMemberID().equals(memberID)) {
                return true;
            }
        }
        return false;
    }
    
    public Member getSelectedMember(ConsoleUser consoleUI) {
        Member selectedMember = null;

        do {
        	displayRepository.displayMemberList(getAllMember());

            String memberID = consoleUI.promptMemberID();
            selectedMember = getMemberNameByID(memberID);

            if (selectedMember == null && consoleUI.promptAddNewMember()) {
                addNewMember(consoleUI);
            } else {
                consoleUI.showMessage("Selected Member: " + (selectedMember != null ? selectedMember.getMemberName() : ""));
            }
        } while (selectedMember == null);

        return selectedMember;
	}
}
