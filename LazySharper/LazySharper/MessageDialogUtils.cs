using System.Windows.Forms;

namespace LazySharper
{
    public class MessageDialogUtils
    {
        public static void ShowErrorMessageDialog(string errorTitle, string errorMessage)
        {
            MessageBox.Show(errorMessage, errorTitle, MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        public static void ShowInfoMessageDialog(string infoTitle, string infoMessage)
        {
            MessageBox.Show(infoMessage, infoTitle, MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}
