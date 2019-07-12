package com.nader.aria.assistant_blue.entities.enums;

public enum NoteType {
    COMMENT(1),
    FILM_LINK(2),
    MUSIC_LINK(3),
    SITE_LINK(4),
    OTHER_LINK(5);

    private int no;

    public int getNo() { return no; }

    private NoteType(int no) { this.no = no; }

}
