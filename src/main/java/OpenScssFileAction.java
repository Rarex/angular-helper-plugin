import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;

public class OpenScssFileAction extends AnAction {
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getProject();
        VirtualFile file = event.getDataContext().getData(PlatformDataKeys.VIRTUAL_FILE);
        if(project != null && file != null) {
            String openUrl = file.getUrl().replaceAll("\\.(\\w)*$", ".scss");
            VirtualFile openVirtualFile = VirtualFileManager.getInstance().findFileByUrl(openUrl);
            if (openVirtualFile != null) {
                FileEditorManager.getInstance(project).openFile(openVirtualFile, true);
            }
        }
    }
}