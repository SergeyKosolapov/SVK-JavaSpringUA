package hw12;

import hw12.Quest;

public class Knight {
    private Quest quest;

    public Knight(Quest quest) {
        this.quest = quest;
    }

    public void moveToQuest() {
        System.out.println("Move to " + quest.getQuest());
    }

    @Override
    public String toString() {
        return "Knight(" +
                "quest="+ quest.getQuest() +
                ")";
    }
}
