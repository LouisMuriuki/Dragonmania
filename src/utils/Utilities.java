package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import island.Island;
import user.Player;

public class Utilities {
	Scanner scanner = new Scanner(System.in);

	public void promptEnterKey() {
		System.out.print("Press Enter");
		try {
			scanner.nextLine();
		} catch (Exception e) {
			scanner.close();
		}
	}

	public void savePlayer() {
		System.out.println("Type 'save' to save game progress");
		if (scanner.nextLine().equals("save")) {
			try (BufferedWriter Bw = new BufferedWriter(new FileWriter("player.txt"));) {
				System.out.println("Saving...");
				Bw.write(Player.name);
				Bw.newLine();
				Bw.write("" + Player.money);
				Bw.newLine();
				Bw.write("" + Player.level);
				Bw.newLine();
				Bw.write("" + Player.dragons);
				Bw.newLine();
				Bw.write(Player.difficulty);
				Bw.newLine();
				Bw.write(Player.mode);
				Bw.newLine();
				Bw.write("" + Player.numberofFights);
				Bw.newLine();
				Bw.write("" + Player.fightswon);
				Bw.newLine();
				Bw.write("" + Player.fightslost);
				Bw.newLine();
				Bw.flush();
				saveIsland();
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Wrong input please Try again");
			promptEnterKey();
			savePlayer();
		}

	}

	public void loadPlayer() {
		try (BufferedReader br = new BufferedReader(new FileReader("player.txt"))) {
			Player.name = br.readLine();
			Player.money = Integer.parseInt(br.readLine());
			Player.level = Integer.parseInt(br.readLine());
			Player.dragons = Integer.parseInt(br.readLine());
			Player.difficulty = br.readLine();
			Player.mode = br.readLine();
			Player.numberofFights = Integer.parseInt(br.readLine());
			Player.fightswon = Integer.parseInt(br.readLine());
			Player.fightslost = Integer.parseInt(br.readLine());
			br.close();
		} catch (Exception e) {

		}
	}

	public void saveIsland() {
		try (BufferedWriter Bw = new BufferedWriter(new FileWriter("island.txt"))) {
			Bw.write("" + Island.habitats);
			Bw.newLine();
			Bw.write("" + Island.farms);
			Bw.newLine();
			Bw.flush();
		} catch (Exception e) {
			

		}
	}

	public void loadIsland() {
		try (BufferedReader br = new BufferedReader(new FileReader("island.txt"));) {
			Island.habitats = Integer.parseInt(br.readLine());
			Island.farms = Integer.parseInt(br.readLine());
			br.close();
		} catch (Exception e) {

		}
	}
	public void startnew() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("player.txt");
		PrintWriter pw1 = new PrintWriter("island.txt");
		pw.close();
		pw1.close();
	}
}
