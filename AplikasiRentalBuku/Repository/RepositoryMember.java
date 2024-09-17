package Repository;

import Entity.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositoryMember {

    public List<Member> getAllMember() {
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("M-001", "Risman", "Bandung"));
        memberList.add(new Member("M-002", "Budi", "Bandung"));
        memberList.add(new Member("M-003", "Resti", "Kab. Bandung"));

        return memberList;
    }

    public void displayMemberList(List<Member> members) {
    	System.out.println("|--------------------------------------------------------------------------------|");
        System.out.println("                                Daftar Member                                     ");
        System.out.println("|--------------------------------------------------------------------------------|");
        System.out.printf("| %-12s | %-40s | %-20s |\n", "Member ID", "Name", "Address");
        System.out.println("|--------------|------------------------------------------|----------------------|");

        for (Member member : members) {
            System.out.printf("| %-12s | %-40s | %-20s |\n",
                    member.getMemberID(), member.getMemberName(), member.getAddress());
        }

        System.out.println("|--------------|------------------------------------------|----------------------|");
    }

    public void listAllMembers() {
        List<Member> allMembers = getAllMember();
        displayMemberList(allMembers);
    }

    public Member getMemberNameByID(String memberID) {
        for (Member member : getAllMember()) {
            if (member.getMemberID().equals(memberID)) {
                return member;
            }
        }
        return null;
    }
    
    public void addNewMember() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Tambahkan Data Member Baru:");
			System.out.print("Masukkan ID Member: ");
			String newMemberID = scanner.nextLine();

			for (Member member : getAllMember()) {
			    if (member.getMemberID().equals(newMemberID)) {
			        System.out.println("ID Member sudah ada. Tidak dapat menambahkan member dengan ID yang sama.");
			        return;
			    }
			}

			System.out.print("Masukkan Nama Member: ");
			String newMemberName = scanner.nextLine();

			System.out.print("Masukkan Alamat Member: ");
			String newMemberAddress = scanner.nextLine();

			Member newMember = new Member(newMemberID, newMemberName, newMemberAddress);

			getAllMember().add(newMember);
		}

        System.out.println("Member baru berhasil ditambahkan!");
    }
}

