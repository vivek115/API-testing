package com.rest.pojo.simple.workspace;

public class WorkspaceRoot {
    Workspace workspace;
    public WorkspaceRoot(){

    }
    public WorkspaceRoot(Workspace workspace){
        this.workspace = workspace;
    }
    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

}
