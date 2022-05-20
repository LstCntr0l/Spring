package App.schedule;

import java.util.List;

public class Schedules {
    private List<Schedule> groups;

    public Schedules() {
    }

    public Schedules(List<Schedule> groups) {
        this.groups = groups;
    }

    public List<Schedule> getGroups() {
        return groups;
    }

    public void setGroups(List<Schedule> groups) {
        this.groups = groups;
    }

    public static class Schedule {
        private String title;
        private List<Schedule.Entry> entries;
        private String collapseId;

        public Schedule() {
        }

        public Schedule(String title, List<Schedule.Entry> entries, String collapseId) {
            this.title = title;
            this.entries = entries;
            this.collapseId = collapseId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Schedule.Entry> getEntries() {
            return entries;
        }

        public void setEntries(List<Schedule.Entry> entries) {
            this.entries = entries;
        }

        public String getCollapseId() {
            return collapseId;
        }

        public void setCollapseId(String collapseId) {
            this.collapseId = collapseId;
        }

        public static class Entry {
            private String id;
            private String name;
            private Boolean done;

            public Entry() {
            }

            public Entry(String id, String name, Boolean done) {
                this.id = id;
                this.name = name;
                this.done = done;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Boolean getDone() {
                return done;
            }

            public void setDone(Boolean done) {
                this.done = done;
            }
        }
    }
}
